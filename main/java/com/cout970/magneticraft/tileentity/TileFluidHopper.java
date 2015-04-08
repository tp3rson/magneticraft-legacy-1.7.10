package com.cout970.magneticraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.cout970.magneticraft.api.util.MgDirection;
import com.cout970.magneticraft.api.util.MgUtils;
import com.cout970.magneticraft.client.gui.component.IGuiSync;
import com.cout970.magneticraft.update1_8.IFluidHandler1_8;
import com.cout970.magneticraft.util.InventoryUtils;
import com.cout970.magneticraft.util.fluid.TankConection;
import com.cout970.magneticraft.util.fluid.TankMg;

public class TileFluidHopper extends TileBase implements IFluidHandler1_8,IGuiSync,ISidedInventory{

	public TankMg tank = new TankMg(this, 5000);
	public ItemStack[] inventory;
	
	public TileFluidHopper(){
		super();
		inventory = new ItemStack[2];
	}

	public void updateEntity() {
		super.updateEntity();
		if (worldObj.isRemote)return;

		if(inventory[0] != null){
			if(tank.getSpace() >= 1000){
				FluidStack f = FluidContainerRegistry.getFluidForFilledItem(inventory[0]);
				if(f != null){
					ItemStack i = inventory[0].getItem().getContainerItem(inventory[0]);
					if(inventory[1] == null || InventoryUtils.canCombine(i, inventory[1],64)){
						inventory[1] = InventoryUtils.addition(i, inventory[1]);
						inventory[0].splitStack(1);
						if(inventory[0].stackSize <= 0)inventory[0] = null;
						tank.fill(f, true);
					}
				}
			}
			if(tank.getFluidAmount() >= 1000){
				if(FluidContainerRegistry.isEmptyContainer(inventory[0])){
					ItemStack h = FluidContainerRegistry.fillFluidContainer(tank.drain(1000, false), inventory[0]);
					
					if(h != null){
						if(inventory[1] == null || InventoryUtils.canCombine(h, inventory[1],64)){
							inventory[1] = InventoryUtils.addition(h, inventory[1]);
							inventory[0].splitStack(1);
							if(inventory[0].stackSize <= 0)inventory[0] = null;
							tank.drain(1000, true);
						}
					}
				}
			}
		}

		if (tank.getSpace() >= 1000) {
			TileEntity t = MgUtils.getTileEntity(this, MgDirection.UP);
			if (t instanceof IFluidHandler) {
				TankConection tan = new TankConection((IFluidHandler) t, MgDirection.DOWN);
				FluidTankInfo[] info = tan.getTankInfo(MgDirection.DOWN);
				for (FluidTankInfo i : info){
					if (i.fluid != null) {
						if (tank.getFluid() == null || i.fluid.isFluidEqual(tank.getFluid())) {
							FluidStack fl = tan.drain(MgDirection.DOWN, 100, false);
							if(fl==null)continue;
							int h = tank.fill(fl, true);
							tan.drain(MgDirection.DOWN, h, true);
							break;
						}
					}
				}
			} else if (worldObj.provider.getWorldTime() % 20 == 0) {
				Block b = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
				if (worldObj.getBlockMetadata(xCoord, yCoord + 1, zCoord) == 0) {
					Fluid f = FluidRegistry.lookupFluidForBlock(b);
					if (f != null) {
						worldObj.setBlockToAir(xCoord, yCoord + 1, zCoord);
						FluidStack resource = new FluidStack(f, 1000);
						tank.fill(resource, true);
					}
				}
			}
		}

		if (tank.getFluidAmount() == 0) return;
		TileEntity t = MgUtils.getTileEntity(this, MgDirection.getDirection(getBlockMetadata()));
		if (t instanceof IFluidHandler) {
			IFluidHandler f = (IFluidHandler) t;
			FluidTankInfo[] infos = f.getTankInfo(ForgeDirection.getOrientation(getBlockMetadata()).getOpposite());
			for (FluidTankInfo info : infos) {
				if (info != null) {
					int amount = info.fluid == null ? 0 : info.fluid.amount;
					int change = Math.min(tank.getFluidAmount(), info.capacity - amount);
					change = Math.min(change, 50);
					if (change > 0) {
						FluidStack resource = tank.drain(change, false);
						int filled = f.fill(
								ForgeDirection.getOrientation(getBlockMetadata()).getOpposite(),
								resource, true);
						tank.drain(filled, true);
					}
				}
			}
		}
	}

	@Override
	public int fill(MgDirection from, FluidStack resource, boolean doFill) {
		if(from != MgDirection.getDirection(getBlockMetadata()))
			return tank.fill(resource, doFill);
		return 0;
	}

	@Override
	public FluidStack drain(MgDirection from, FluidStack resource,
			boolean doDrain) {
		return drain(from, resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(MgDirection from, int maxDrain, boolean doDrain) {
		return tank.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFill(MgDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(MgDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(MgDirection from) {
		return new FluidTankInfo[] { tank.getInfo() };
	}

	@Override
	public void sendGUINetworkData(Container cont, ICrafting craft) {
		if(tank.getFluidAmount() > 0){
			craft.sendProgressBarUpdate(cont, 0, tank.getFluid().fluidID);
		}
		craft.sendProgressBarUpdate(cont, 1, tank.getFluidAmount());
	}

	@Override
	public void getGUINetworkData(int i, int value) {
		if(i == 0)tank.setFluid(new FluidStack(FluidRegistry.getFluid(value),1));
		if(i == 1){
			if(value == 0){
				tank.setFluid(null);
			}else
				tank.setFluid(new FluidStack(tank.getFluid(), value));
		}
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int var1) {
		return inventory[var1];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack itemStack = getStackInSlot(slot);
		if (itemStack != null) {
			if (itemStack.stackSize <= amount) {
				setInventorySlotContents(slot, null);
			}
			else {
				itemStack = itemStack.splitStack(amount);
				if (itemStack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}
		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return inventory[var1];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		inventory[slot] = itemStack;

		if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}
		markDirty();
	}

	@Override
	public String getInventoryName() {
		return "Fluid Hopper";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound) {

		super.readFromNBT(nbtTagCompound);
		tank.readFromNBT(nbtTagCompound, "fluid");
		NBTTagList tagList = nbtTagCompound.getTagList("Inventory", 10);
		inventory = new ItemStack[this.getSizeInventory()];
		for (int i = 0; i < tagList.tagCount(); ++i) {
			NBTTagCompound tagCompound = (NBTTagCompound) tagList.getCompoundTagAt(i);
			byte slot = tagCompound.getByte("Slot");
			if (slot >= 0 && slot < inventory.length) {
				inventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound) {
		super.writeToNBT(nbtTagCompound);
		tank.writeToNBT(nbtTagCompound, "fluid");
		NBTTagList list = new NBTTagList();
		for (int currentIndex = 0; currentIndex < inventory.length; ++currentIndex) {
			if (inventory[currentIndex] != null) {
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setByte("Slot", (byte) currentIndex);
				inventory[currentIndex].writeToNBT(nbt);
				list.appendTag(nbt);
			}
		}
		nbtTagCompound.setTag("Inventory", list);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return new int[]{0,1};
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack i,
			int side) {
		return slot == 0;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack i,
			int side) {
		return slot == 1;
	}
}
