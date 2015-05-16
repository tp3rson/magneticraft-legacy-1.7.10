package com.cout970.magneticraft.items;

import com.cout970.magneticraft.handlers.HandlerBuckets;
import com.cout970.magneticraft.util.Log;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;


public class ItemBucket extends ItemBasic{
	
	public String fluid;

	public ItemBucket(String unlocalizedname, String fluid) {
		super(unlocalizedname);
		this.fluid = fluid;
		setMaxStackSize(1);
	}
	
	public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p)
	{
		if(w.isRemote)return i;
		FluidStack f = HandlerBuckets.INSTANCE.getFluid(i);
		
		if(f != null){
			MovingObjectPosition mop = this.getMovingObjectPositionFromPlayer(w, p, false);
			if(mop == null)return i;
			if(f.getFluid() == null || f.getFluid().getBlock() == null)return i;
			Block b = f.getFluid().getBlock();
			if(mop.sideHit == 0)mop.blockY--;
			if(mop.sideHit == 1)mop.blockY++;
			if(mop.sideHit == 2)mop.blockZ--;
			if(mop.sideHit == 3)mop.blockZ++;
			if(mop.sideHit == 4)mop.blockX--;
			if(mop.sideHit == 5)mop.blockX++;
			if(w.getBlock(mop.blockX, mop.blockY, mop.blockZ) == null || w.getBlock(mop.blockX, mop.blockY, mop.blockZ).isReplaceable(w, mop.blockX, mop.blockY, mop.blockZ)){
				w.setBlock(mop.blockX, mop.blockY, mop.blockZ, b);
				w.notifyBlockOfNeighborChange(mop.blockX, mop.blockY, mop.blockZ, b);
				if(p != null && !p.capabilities.isCreativeMode)
				return i.getItem().getContainerItem(i);
				else return i;
			}
		}
		return i;
	}
	
	public ItemStack getContainerItem(ItemStack i){
		return new ItemStack(Items.bucket);
	}
}
