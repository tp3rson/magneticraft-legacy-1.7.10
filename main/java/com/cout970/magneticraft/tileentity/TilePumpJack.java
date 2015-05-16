package com.cout970.magneticraft.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.cout970.magneticraft.ManagerBlocks;
import com.cout970.magneticraft.api.electricity.Conductor;
import com.cout970.magneticraft.api.electricity.ElectricConstants;
import com.cout970.magneticraft.api.electricity.IElectricConductor;
import com.cout970.magneticraft.api.util.BlockInfo;
import com.cout970.magneticraft.api.util.BlockPosition;
import com.cout970.magneticraft.api.util.MgDirection;
import com.cout970.magneticraft.api.util.MgUtils;
import com.cout970.magneticraft.block.BlockMg;
import com.cout970.magneticraft.update1_8.IFluidHandler1_8;
import com.cout970.magneticraft.util.Log;
import com.cout970.magneticraft.util.fluid.TankMg;
import com.cout970.magneticraft.util.tile.TileConductorLow;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TilePumpJack extends TileConductorLow implements IFluidHandler1_8{

	//client
	public float m;
	public MgDirection facing;
	public boolean active;
	//server
	public TankMg tank = new TankMg(this, 4000);
	public long time;
	private List<BlockPosition> pipes = new ArrayList<BlockPosition>();
	private List<BlockPosition> oil = new ArrayList<BlockPosition>();
	private List<BlockPosition> finder = new ArrayList<BlockPosition>();
	private List<BlockPosition> Visited = new ArrayList<BlockPosition>();
	private int alt;
	private boolean update;
	private int cooldown;
	private boolean blocked;
	private MgDirection[] sides = {MgDirection.NORTH,MgDirection.EAST,MgDirection.SOUTH,MgDirection.WEST,MgDirection.DOWN,MgDirection.UP};
	private int buffer;
	public static Block replacement = ManagerBlocks.oilSourceDrained;
	private int Speed = 50;
	private boolean working;
	

	@Override
	public IElectricConductor initConductor() {
		return new Conductor(this);
	}

	public void updateEntity(){
		super.updateEntity();
		
		if(!update)
			facing = getOrientation(getBlockMetadata());
		

		if(cond.getVoltage() > ElectricConstants.MACHINE_WORK){	
			working = true;
		}else{
			working = false;
		}

		if(worldObj.getWorldTime()%20 == 0){
			if(working && !isActive()){
				setActive(true);
			}else if(!working && isActive()){
				setActive(false);
			}
		}
		
		if(worldObj.isRemote)return;

		if(!update){
			if(worldObj.provider.getWorldTime() % 80 == 0)
				update = searchForOil();
			export();
			return;
		}

		if(worldObj.getWorldTime()%80 == 0){
			if(alt != 0){
				pipes.clear();
				for(int y=yCoord-1;y>0;y--){
					Block b = worldObj.getBlock(xCoord+facing.getOffsetX(), y, zCoord+facing.getOffsetZ());
					if(Block.isEqualTo(b, ManagerBlocks.oilSource) || Block.isEqualTo(b, replacement)){
						break;
					}else if(!Block.isEqualTo(b, ManagerBlocks.concreted_pipe)){
						pipes.add(new BlockPosition(xCoord+facing.getOffsetX(), y, zCoord+facing.getOffsetZ()));
					} 
				}
			}
			blocked = false;
		}
		

		export();
		if(!blocked){
			if(cooldown > 0)cooldown--;
			if(cooldown <= 0){
				cooldown = 20;
				if(pipes.size() == 0){
					getOil();
					blocked = true;
				}else{
					if(cond.getVoltage() > ElectricConstants.MACHINE_WORK){
						BlockPosition c = pipes.get(0);
						ReplaceBlock(c.getX(),c.getY(),c.getZ(),ManagerBlocks.concreted_pipe);
						cond.drainPower(1000);
						pipes.remove(0);
					}
				}
			}
		}
		if(blocked){
			if(cond.getVoltage() > ElectricConstants.MACHINE_WORK && tank.getSpace() > 0 && buffer > 0){
				int i =  Math.min(Speed,buffer);
				buffer -= tank.fill(FluidRegistry.getFluidStack("oil", i), true);
				cond.drainPower(i*100);
			}

			if(buffer <= 0){
				if(oil.size() == 0){
					update = false;
					blocked = false;
					return;
				}else{
					BlockPosition b = oil.get(0);
					int m = worldObj.getBlockMetadata(b.getX(), b.getY(), b.getZ());
					if(m > 0){
						worldObj.setBlockMetadataWithNotify(b.getX(), b.getY(), b.getZ(), m-1, 2);
					}else{
						worldObj.setBlock(b.getX(), b.getY(), b.getZ(), replacement);
						oil.remove(0);
					}
					buffer = 1000;
				}
			}
		}
	}
	
	public void ReplaceBlock(int x, int y, int z, Block remplace) {
		if(worldObj.getBlock(x,y,z).isAir(worldObj, x, y, z) || MgUtils.isMineableBlock(worldObj,new BlockInfo(worldObj.getBlock(x,y,z),worldObj.getBlockMetadata(x, y, z),x,y,z))){
			ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			Block id = worldObj.getBlock(x,y,z);
			int metadata = worldObj.getBlockMetadata(x,y,z);
			items = id.getDrops(worldObj, x, y, z, metadata, 0);
			for(ItemStack i : items)
				BlockMg.dropItem(i, worldObj.rand, xCoord, yCoord, zCoord, worldObj);

			worldObj.setBlock(x, y, z, remplace);
		}
	}

	private void setActive(boolean b) {
		active = b;
		sendUpdateToClient();
	}

	public boolean isActive() {
		return active;
	}

	private void export() {
		if(tank.getFluidAmount() > 0){
			for(MgDirection d : MgDirection.VALID_DIRECTIONS){
				TileEntity t = MgUtils.getTileEntity(this, d);
				if(t instanceof IFluidHandler){
					IFluidHandler f = (IFluidHandler) t;
					if(f.canFill(d.getForgeDir(), FluidRegistry.getFluid("oil"))){
						int m = f.fill(d.getForgeDir(), tank.drain(100, false), true);
						tank.drain(m, true);
					}
					if(tank.getFluidAmount() == 0)break;
				}
			}
		}
	}

	private void getOil() {
		oil.clear();
		pathFinder(new BlockPosition(xCoord, alt, zCoord));
		Visited.clear();
		finder.clear();
	}

	public void pathFinder(BlockPosition c){
		if(oil.size() > 20)return;
		if(Visited.size() > 4000){
			alt--;
			return;
		}
		for(MgDirection d : sides){
			BlockPosition bc = new BlockPosition(c.getX()+d.getOffsetX(), c.getY()+d.getOffsetY(), c.getZ()+d.getOffsetZ());
			if(Visited.contains(bc))continue;
			Visited.add(bc);

			Block b = worldObj.getBlock(bc.getX(), bc.getY(), bc.getZ());
			int m = worldObj.getBlockMetadata(bc.getX(), bc.getY(), bc.getZ());

			if(Block.isEqualTo(b, ManagerBlocks.oilSource)){ 
				oil.add(bc);
				if(!finder.contains(bc))finder.add(bc);
			}else if(Block.isEqualTo(b,replacement)){
				if(!finder.contains(bc))finder.add(bc);
			}
		}
		List<BlockPosition> temp = new ArrayList<BlockPosition>();
		temp.addAll(finder);
		for(BlockPosition cc : temp){
			finder.remove(cc);
			pathFinder(cc);
		}
	}

	public boolean searchForOil(){
		pipes.clear();
		for(int y=yCoord-1;y>0;y--){
			Block b = worldObj.getBlock(xCoord+facing.getOffsetX(), y, zCoord+facing.getOffsetZ());
			if(Block.isEqualTo(b, ManagerBlocks.oilSource) || Block.isEqualTo(b, replacement)){
				alt = y;
				getOil();
				if(oil.isEmpty()){
					alt = 0;
				}else{
					return true;
				}
			}else if(!Block.isEqualTo(b, ManagerBlocks.concreted_pipe)){
				pipes.add(new BlockPosition(xCoord+facing.getOffsetX(), y, zCoord+facing.getOffsetZ()));
			} 
		}
		return false;
	}


	@Override
	public int fillMg(MgDirection from, FluidStack resource, boolean doFill) {
		return 0;
	}

	@Override
	public FluidStack drainMg_F(MgDirection from, FluidStack resource,
			boolean doDrain) {
		return drainMg(from, resource.amount, doDrain);
	}

	@Override
	public FluidStack drainMg(MgDirection from, int maxDrain, boolean doDrain) {
		return tank.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFillMg(MgDirection from, Fluid fluid) {
		return false;
	}

	@Override
	public boolean canDrainMg(MgDirection from, Fluid fluid) {
		return fluid.getName() == "oil";
	}

	@Override
	public FluidTankInfo[] getTankInfoMg(MgDirection from) {
		return new FluidTankInfo[]{tank.getInfo()};
	}

	public float getDelta() {
		long aux = time;
		time = System.nanoTime();
		return time - aux;
	}
	
	public MgDirection getOrientation(int meta) {
		if(meta == 0)return MgDirection.EAST;
		if(meta == 1)return MgDirection.SOUTH;
		if(meta == 2)return MgDirection.WEST;
		if(meta == 3)return MgDirection.NORTH;
		return MgDirection.NORTH;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		tank.readFromNBT(nbt, "oil");
		buffer = nbt.getInteger("Buffer");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		tank.writeToNBT(nbt, "oil");
		nbt.setInteger("Buffer", buffer);
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox()
    {
        return INFINITE_EXTENT_AABB;
    }
}
