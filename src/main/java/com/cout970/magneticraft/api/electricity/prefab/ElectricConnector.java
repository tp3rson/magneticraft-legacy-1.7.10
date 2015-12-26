package com.cout970.magneticraft.api.electricity.prefab;

import com.cout970.magneticraft.api.electricity.ElectricUtils;
import com.cout970.magneticraft.api.electricity.IElectricConductor;
import com.cout970.magneticraft.api.electricity.IElectricPole;
import com.cout970.magneticraft.api.electricity.IInterPoleWire;
import com.cout970.magneticraft.api.util.VecDouble;
import com.cout970.magneticraft.api.util.VecInt;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class ElectricConnector implements IElectricPole {

    public boolean update = true;
    //wire render only
    public int glList = -1;
    protected List<IInterPoleWire> connections = new ArrayList<>();
    protected IElectricConductor cond;
    protected TileEntity parent;
    private int connectionsBlocked;

    public ElectricConnector(TileEntity tile, IElectricConductor cond) {
        parent = tile;
        this.cond = cond;
        connectionsBlocked = 1;
    }

    public static void findConnections(IElectricPole pole) {
        pole.disconnectAll();
        int rad = 16;
        for (int x = -rad; x <= rad; x++) {
            for (int z = -rad; z <= rad; z++) {
                for (int y = -5; y <= 5; y++) {
                    if (x == 0 && z == 0) continue;
                    TileEntity t = new VecInt(pole.getParent()).add(x, y, z).getTileEntity(pole.getParent().getWorldObj());
                    IElectricPole p = ElectricUtils.getElectricPole(t);
                    if (p == null) continue;
                    if (p.canConnectWire(0, pole, false) && pole.canConnectWire(0, p, false)) {
                        InterPoleWire wire = new InterPoleWire(new VecInt(pole.getParent()), new VecInt(p.getParent()));
                        wire.setWorld(p.getParent().getWorldObj());
                        pole.onConnect(wire);
                        p.onConnect(wire);
                    }
                }
            }
        }
    }

    @Override
    public void disconnectAll() {
        update = true;
        ArrayList<IInterPoleWire> list = new ArrayList<>();
        list.addAll(connections);
        for (IInterPoleWire con : list) {
            if (con.getWorld() == null) {
                if (parent == null) continue;
                con.setWorld(parent.getWorldObj());
            }
            if (con.getStart() != null) con.getStart().onDisconnect(con);
            if (con.getEnd() != null) con.getEnd().onDisconnect(con);
        }
    }

    @Override
    public void iterate() {
        if (update) {
            update = false;
            for (IInterPoleWire c : connections) {
                c.setWorld(getParent().getWorldObj());
            }
            refreshList();
        }
        if (parent.getWorldObj().isRemote) return;
        connections.stream().filter(c -> c.getStart() == this).forEach(com.cout970.magneticraft.api.electricity.IInterPoleWire::iterate);
    }

    @Override
    public List<IInterPoleWire> getConnectedConductors() {
        return connections;
    }

    @Override
    public boolean canConnectWire(int tier, IElectricPole to, boolean isManual) {
        if (to == this) return false;
        if (tier != 0) return false;
        VecDouble vec = new VecDouble(getParent()).add(new VecDouble(to.getParent()).getOpposite());
        if (vec.mag() > 16) return false;
        for (IInterPoleWire i : connections) {
            if (i.vecStart().equals(new VecInt(getParent()))) {
                if (i.vecEnd().equals(new VecInt(to.getParent()))) {
                    return false;
                }
            }
        }
        if (isManual && (connectionsBlocked >= 2)) {
            return false;
        } else if (!isManual && (connectionsBlocked >= 1)) {
            return false;
        }

        return !(to instanceof ElectricConnector) && (connections.size() == 0);

    }

    @Override
    public void onDisconnect(IInterPoleWire conn) {
        connections.remove(conn);
        refreshList();
    }

    @Override
    public int getTier() {
        return 0;
    }

    @Override
    public TileEntity getParent() {
        return parent;
    }

    @Override
    public IElectricConductor getConductor() {
        return cond;
    }

    @Override
    public VecDouble[] getWireConnectors() {
        switch (getParent().getBlockMetadata() - 6) {
            case 0:
                return new VecDouble[]{new VecDouble(1.845, 0.75, 0.5), new VecDouble(0.5, 1, 0.5), new VecDouble(-0.845, 0.75, 0.5)};
            case 4:
                return new VecDouble[]{new VecDouble(-0.845, 0.75, 0.5), new VecDouble(0.5, 1, 0.5), new VecDouble(1.845, 0.75, 0.5)};

            case 1:
                return new VecDouble[]{new VecDouble(1.45, 0.75, 1.45), new VecDouble(0.5, 1, 0.5), new VecDouble(-0.45, 0.75, -0.45)};
            case 5:
                return new VecDouble[]{new VecDouble(-0.45, 0.75, -0.45), new VecDouble(0.5, 1, 0.5), new VecDouble(1.45, 0.75, 1.45)};

            case 3:
                return new VecDouble[]{new VecDouble(-0.45, 0.75, 1.45), new VecDouble(0.5, 1, 0.5), new VecDouble(1.45, 0.75, -0.45)};
            case 7:
                return new VecDouble[]{new VecDouble(1.45, 0.75, -0.45), new VecDouble(0.5, 1, 0.5), new VecDouble(-0.45, 0.75, 1.45)};

            case 2:
                return new VecDouble[]{new VecDouble(0.5, 0.75, 1.845), new VecDouble(0.5, 1, 0.5), new VecDouble(0.5, 0.75, -0.845)};
            case 6:
                return new VecDouble[]{new VecDouble(0.5, 0.75, -0.845), new VecDouble(0.5, 1, 0.5), new VecDouble(0.5, 0.75, 1.845)};
        }
        return new VecDouble[]{};
    }

    @Override
    public void onConnect(IInterPoleWire wire) {
        connections.add(wire);
        update = true;
    }

    private void refreshList() {
        if (getParent().getWorldObj().isRemote) {
            if (glList != -1) {
                GL11.glDeleteLists(glList, 1);
                glList = -1;
            }
        }
    }

    public int getConnectionMode() {
        return connectionsBlocked;
    }

    public void setConnectionMode(int mode) {
        disconnectAll();
        connectionsBlocked = mode;
    }

    public void blockAllConnections() {
        disconnectAll();
        connectionsBlocked = 2;
    }

    public void blockAutoConnections() {
        disconnectAll();
        connectionsBlocked = 1;
    }

    public void allowConnections() {
        findConnections(this);
        connectionsBlocked = 0;
    }

    @Override
    public void save(NBTTagCompound nbt) {
        NBTTagList nbtList = new NBTTagList();
        for (IInterPoleWire c : connections) {
            NBTTagCompound tag = new NBTTagCompound();
            c.save(tag);
            nbtList.appendTag(tag);
        }
        nbt.setTag("connect", nbtList);
        nbt.setInteger("mode", connectionsBlocked);
    }

    @Override
    public void load(NBTTagCompound nbt) {
        update = true;
        NBTTagList nbtList = nbt.getTagList("connect", 10);
        connections.clear();
        for (int i = 0; i < nbtList.tagCount(); i++) {
            NBTTagCompound tag = nbtList.getCompoundTagAt(i);
            InterPoleWire p = new InterPoleWire();
            p.load(tag);
            connections.add(p);
        }
        connectionsBlocked = nbt.getInteger("mode");
    }
}
