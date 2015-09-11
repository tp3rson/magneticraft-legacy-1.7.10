package com.cout970.magneticraft.tileentity.pole;

import com.cout970.magneticraft.api.electricity.IElectricConductor;
import com.cout970.magneticraft.api.electricity.IElectricPole;
import com.cout970.magneticraft.api.electricity.IInterPoleWire;
import com.cout970.magneticraft.api.electricity.ITileElectricPole;
import com.cout970.magneticraft.api.electricity.prefab.ElectricConductor;
import com.cout970.magneticraft.api.electricity.prefab.ElectricConnector;
import com.cout970.magneticraft.api.util.EnergyConversor;
import com.cout970.magneticraft.api.util.MgUtils;
import com.cout970.magneticraft.api.util.VecInt;
import com.cout970.magneticraft.util.tile.TileConductorLow;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileElectricConnector extends TileConductorLow implements ITileElectricPole {

    public ElectricConnector pole;
    private double flow;
    public boolean clientUpdate = false;
    public boolean updateCables = true;
    public boolean locked = false;

    private int ticksUntilUpdate = 0;
    private static final int UPDATE_PAUSE = 100;

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return INFINITE_EXTENT_AABB;
    }

    public void onBlockBreaks() {
        pole.disconnectAll();
    }

    public void onNeigChange() {
        super.onNeigChange();
        updateCables = true;
    }

    public void updateEntity() {
        if (ticksUntilUpdate == 0) {
            clientUpdate = true;
        }
        ticksUntilUpdate = (ticksUntilUpdate + 1) % UPDATE_PAUSE;

        super.updateEntity();
        if (updateCables && !locked && (pole.getConnectionMode() == 0)) {
            findConnections();
            updateCables = false;
        }
        pole.iterate();
        TileEntity t = getBase();
        if (t != null) {
            IElectricConductor[] comp = ((TileElectricConnectorDown) t).getConds(VecInt.NULL_VECTOR, 0);
            if (comp != null) {
                IElectricConductor to = comp[0];
                double resistance = (to.getResistance() + cond.getResistance());
                //the voltage difference
                double deltaV = to.getVoltage() - cond.getVoltage();
                //sanity check for infinite current
                if (Double.isNaN(flow)) flow = 0;
                //the extra current from the last tick
                double current = flow;
                // (V - I*R) I*R is the voltage difference that this conductor should have using the ohm's law, and V the real one
                //vDiff is the voltage difference between the current voltage difference and the proper voltage difference using the ohm's law
                double vDiff = (deltaV - current * resistance);
                //make sure the vDiff is not in the incorrect direction when the resistance is too big
                vDiff = Math.min(vDiff, Math.abs(deltaV));
                vDiff = Math.max(vDiff, -Math.abs(deltaV));
                // add to the next tick current an extra to get the proper voltage difference on the two conductors
                flow += (vDiff * to.getIndScale()) / to.getVoltageMultiplier();
                // to the extra current add the current generated by the voltage difference
                current += (deltaV * to.getCondParallel()) / (to.getVoltageMultiplier());
                //moves the charge
                to.applyCurrent(-current);
                cond.applyCurrent(current);
            }
        }
        if (clientUpdate) {
            clientUpdate = false;
            sendUpdateToClient();
        }
    }

    public void findConnections() {
        ElectricConnector.findConnections(pole);
        clientUpdate = true;
    }

    @Override
    public IElectricConductor[] getConds(VecInt dir, int Vtier) {
        if (dir == VecInt.NULL_VECTOR && Vtier == 0) return new IElectricConductor[]{cond};
        return null;
    }

    @Override
    public IElectricPole getPoleConnection() {
        return pole;
    }

    @Override
    public ITileElectricPole getMainTile() {
        return this;
    }

    @Override
    public IElectricConductor initConductor() {
        cond = new ElectricConductor(this) {
            @Override
            public double getInvCapacity() {
                return getVoltageMultiplier() * EnergyConversor.RFtoW(0.8D);
            }
        };
        pole = new ElectricConnector(this, cond) {
            @Override
            public void onDisconnect(IInterPoleWire conn) {
                super.onDisconnect(conn);
                clientUpdate = true;
            }
        };
        return cond;
    }

    public TileElectricConnectorDown getBase() {
        VecInt vec = new VecInt(0, -1, 0);
        TileEntity t = MgUtils.getTileEntity(this, vec);
        if (t instanceof TileElectricConnectorDown) return (TileElectricConnectorDown) t;
        return null;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        flow = nbt.getDouble("energyFlow");
        pole.load(nbt);
        locked = nbt.getBoolean("Locked");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setDouble("energyFlow", flow);
        pole.save(nbt);
        nbt.setBoolean("Locked", locked);
    }
}
