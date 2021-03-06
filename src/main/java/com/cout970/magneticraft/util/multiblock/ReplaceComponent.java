package com.cout970.magneticraft.util.multiblock;

import com.cout970.magneticraft.Magneticraft;
import com.cout970.magneticraft.api.util.MgDirection;
import com.cout970.magneticraft.api.util.VecInt;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ReplaceComponent extends Mg_Component {

    public Block origin;
    private Block replace;

    public ReplaceComponent(Block or, Block re) {
        origin = or;
        replace = re;
    }

    public boolean isCorrect(World w, VecInt p, int x, int y, int z, Multiblock c, MgDirection e, int meta) {
        VecInt te = c.translate(w, p, x, y, z, c, e, meta);
        Block t = w.getBlock(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ());
        if (!Block.isEqualTo(origin, t)) {
            if (Magneticraft.DEBUG)
                w.setBlock(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ(), origin);
            return false;
        }
        return true;
    }

    public void establish(World w, VecInt p, int x, int y, int z, Multiblock c, MgDirection e, int meta) {
        VecInt te = c.translate(w, p, x, y, z, c, e, meta);
        Block t = w.getBlock(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ());
        int metadata = w.getBlockMetadata(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ());
        ArrayList<ItemStack> drops = t.getDrops(w, te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ(), metadata, 0);
        w.setBlock(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ(), replace);
        t = w.getBlock(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ());
        if (t instanceof MB_Block) {
            ((MB_Block) t).mutates(w, new VecInt(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ()), c, e);
        }
        TileEntity tile = w.getTileEntity(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ());
        if (tile instanceof MB_Tile) {
            ((MB_Tile) tile).setControlPos(p);
            ((MB_Tile) tile).setDirection(e);
            ((MB_Tile) tile).setMultiblock(c);
            ((MB_Tile) tile).onActivate(w, p, c, e);
        }
        if (tile instanceof MB_Tile_Replaced) {
            ((MB_Tile_Replaced) tile).setDrops(drops);
        }
    }

    public void destroy(World w, VecInt p, int x, int y, int z, Multiblock c, MgDirection e, int meta) {
        VecInt te = c.translate(w, p, x, y, z, c, e, meta);
        TileEntity tile = w.getTileEntity(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ());
        if (tile instanceof MB_Tile) {
            ((MB_Tile) tile).onDestroy(w, p, c, e);
            ((MB_Tile) tile).setControlPos(null);
            ((MB_Tile) tile).setMultiblock(null);
            ((MB_Tile) tile).setDirection(null);
        }
        Block t = w.getBlock(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ());
        if (t instanceof MB_Block) {
            ((MB_Block) t).destroy(w, new VecInt(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ()), c, e);
        }
        if (!Block.isEqualTo(t, Blocks.air)) {
            w.setBlock(te.getX() + p.getX(), te.getY() + p.getY(), te.getZ() + p.getZ(), origin);
        }
    }

    public String getErrorMessage(World w, VecInt p, int x, int y, int z, Multiblock c, MgDirection e, int meta) {
        VecInt k = c.translate(w, p, x, y, z, c, e, meta).add(p);
        return "Error in " + k.getX() + " " + k.getY() + " " + k.getZ() + " with the block: " + origin.getLocalizedName();
    }

}
