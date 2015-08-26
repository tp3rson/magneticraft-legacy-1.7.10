package com.cout970.magneticraft.util.energy;

import cofh.api.energy.IEnergyHandler;
import com.cout970.magneticraft.api.electricity.IEnergyInterface;
import com.cout970.magneticraft.api.electricity.IIndexedConnection;
import com.cout970.magneticraft.api.util.EnergyConversor;
import com.cout970.magneticraft.api.util.MgDirection;
import com.cout970.magneticraft.api.util.VecInt;
import net.minecraft.tileentity.TileEntity;

public class RF_EnergyInterface implements IEnergyInterface {

    private IEnergyHandler tile;
    private MgDirection dir;

    public RF_EnergyInterface(IEnergyHandler g, MgDirection dir) {
        tile = g;
        this.dir = dir;
    }

    @Override
    public double applyEnergy(double watts) {
        return EnergyConversor.RFtoW(tile.receiveEnergy(dir.toForgeDir(), (int) EnergyConversor.WtoRF(watts), false));
    }

    @Override
    public double getCapacity() {
        return EnergyConversor.RFtoW(tile.getMaxEnergyStored(dir.toForgeDir()));
    }

    @Override
    public double getEnergyStored() {
        return EnergyConversor.RFtoW(tile.getEnergyStored(dir.toForgeDir()));
    }

    @Override
    public double getMaxFlow() {
        return EnergyConversor.RFtoW(80);
    }

    @Override
    public TileEntity getParent() {
        return (TileEntity) tile;
    }

    @Override
    public boolean canConnect(VecInt f) {
        return tile.canConnectEnergy(dir.toForgeDir());
    }

    @Override
    public boolean canAcceptEnergy(IIndexedConnection f) {
        return true;
    }

}
