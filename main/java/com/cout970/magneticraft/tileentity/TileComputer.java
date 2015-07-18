package com.cout970.magneticraft.tileentity;

import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.cout970.magneticraft.api.computer.IPeripheral;
import com.cout970.magneticraft.api.computer.IComputer;
import com.cout970.magneticraft.api.computer.IHardwareProvider;
import com.cout970.magneticraft.api.computer.IHardwareProvider.ModuleType;
import com.cout970.magneticraft.api.computer.IModuleCPU;
import com.cout970.magneticraft.api.computer.IModuleDiskDrive;
import com.cout970.magneticraft.api.computer.IModuleMemoryController;
import com.cout970.magneticraft.api.computer.IModuleROM;
import com.cout970.magneticraft.api.computer.impl.ModuleDisckDrive;
import com.cout970.magneticraft.api.computer.impl.ModuleHardDrive;
import com.cout970.magneticraft.block.BlockMg;
import com.cout970.magneticraft.client.gui.component.IGuiSync;
import com.cout970.magneticraft.util.IGuiListener;
import com.cout970.magneticraft.util.InventoryComponent;
import com.cout970.magneticraft.util.Log;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class TileComputer extends TileBase implements IGuiListener,IGuiSync, IComputer{
	
	private IModuleCPU procesor;
	private IModuleMemoryController memory;
	private IModuleROM rom;
	private ModuleHardDrive hardDrive;
	private ModuleDisckDrive floppyDrive;
	private boolean isRuning;
	public int addres = 0;
	
	private InventoryComponent inv = new InventoryComponent(this, 5, "Computer"){
		@Override
		public void setInventorySlotContents(int slot, ItemStack itemStack) {
			inventory[slot] = itemStack;

			if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
				itemStack.stackSize = this.getInventoryStackLimit();
			}
			markDirty();
			if(slot == 3)hardDrive.insertDisk(itemStack);
			if(slot == 4)floppyDrive.insertDisk(itemStack);
		}
		
		@Override
		public int getInventoryStackLimit() {
			return 1;
		}
	};
	
	public IPeripheral motherboard = new IPeripheral() {
		
		@Override
		public int getAddress() {
			return addres;
		}

		@Override
		public void setAddress(int address) {
			addres = address;
		}

		@Override
		public boolean isActive() {
			return procesor != null && memory != null && rom != null;
		}
		
		@Override
		public void writeByte(int pointer, int data) {}
		
		@Override
		public int readByte(int pointer) {
			return 0;
		}
		
		@Override
		public TileEntity getParent() {
			return TileComputer.this;
		}
		
		@Override
		public String getName() {
			return "Computer";
		}
	};
	
	public TileComputer(){
		hardDrive = new ModuleHardDrive(this);
		floppyDrive = new ModuleDisckDrive(this);
	}
	
	public void onBlockBreaks(){
		for(int i = 0; i<getInv().getSizeInventory();i++){
			if(getInv().getStackInSlot(i) != null)
			BlockMg.dropItem(getInv().getStackInSlot(i), worldObj.rand, xCoord, yCoord, zCoord, worldObj);
		}
	}

	public void updateEntity(){
		if(worldObj.isRemote)return;
		long time = System.nanoTime();
		if(motherboard.isActive()){
			procesor.iterate();
			hardDrive.iterate();
			floppyDrive.iterate();
		}
		if(worldObj.getTotalWorldTime() % 100 == 0){
				chechHardware();
//				sendUpdateToClient();
		}
//		Log.debug((System.nanoTime()-time)/1000);
	}
	
	public Packet getDescriptionPacket(){
		NBTTagCompound nbt = new NBTTagCompound();
//		this.writeToNBT(nbt);
		S35PacketUpdateTileEntity p = new S35PacketUpdateTileEntity(xCoord,yCoord,zCoord,0,nbt);
		return p;
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
//		this.readFromNBT(pkt.func_148857_g());
	}

	private void chechHardware() {
		ItemStack cpu = getInv().getStackInSlot(0);
		ItemStack ram = getInv().getStackInSlot(1);
		ItemStack rom = getInv().getStackInSlot(2);
		boolean hasCpu = false, hasRam = false, hasRom = false;
		if(cpu == null || ram == null || rom == null){
			procesor = null;
			memory = null;
			this.rom = null;
			return;
		}
		ModuleType m = null;
		if(cpu.getItem() instanceof IHardwareProvider){
			m = ((IHardwareProvider) cpu.getItem()).getModuleType(cpu);
			if(m == ModuleType.CPU){
				hasCpu = true;
			}
		}
		if(ram.getItem() instanceof IHardwareProvider){
			m = ((IHardwareProvider) ram.getItem()).getModuleType(ram);
			if(m == ModuleType.RAM){
				hasRam = true;
			}
		}
		if(rom.getItem() instanceof IHardwareProvider){
			m = ((IHardwareProvider) rom.getItem()).getModuleType(rom);
			if(m == ModuleType.ROM){
				hasRom = true;
			}
		}
		if(hasCpu && hasRam && hasRom)weldHardware();
		else{
			procesor = null;
			memory = null;
			this.rom = null;
		}
	}

	public void weldHardware(){
		if(!motherboard.isActive()){
			procesor = (IModuleCPU) ((IHardwareProvider)getInv().getStackInSlot(0).getItem()).getHardware(getInv().getStackInSlot(0));
			memory = (IModuleMemoryController) ((IHardwareProvider)getInv().getStackInSlot(1).getItem()).getHardware(getInv().getStackInSlot(1));
			rom = (IModuleROM) ((IHardwareProvider)getInv().getStackInSlot(2).getItem()).getHardware(getInv().getStackInSlot(2));
			procesor.connectMemory(memory);
			memory.setComputer(this);
		}
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		isRuning = nbt.getBoolean("ON");
		addres = nbt.getInteger("Address");
		floppyDrive.load(nbt);
		hardDrive.load(nbt);
		getInv().readFromNBT(nbt);
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER){
			if(!motherboard.isActive())chechHardware();
			if(motherboard.isActive()){
				procesor.loadRegisters(nbt);
				memory.loadMemory(nbt);
				floppyDrive.load(nbt);
				hardDrive.load(nbt);
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setBoolean("ON", isRunning());
		nbt.setInteger("Address", addres);
		floppyDrive.save(nbt);
		hardDrive.save(nbt);
		getInv().writeToNBT(nbt);
		if(motherboard.isActive()){
			procesor.saveRegisters(nbt);
			memory.saveMemory(nbt);
			floppyDrive.save(nbt);
			hardDrive.save(nbt);
		}
	}

	@Override
	public void onMessageReceive(int id, int dato) {
		if(motherboard.isActive()){
			if(id == 0){
				if(!procesor.isRunning()){
					procesor.start();
					rom.loadToRAM(memory);
					sendUpdateToClient();
				}
			}else if(id == 1){
				procesor.stop();
				procesor.start();
				rom.loadToRAM(memory);
				sendUpdateToClient();
			}else if(id == 2){
				procesor.stop();
				sendUpdateToClient();
			}
		}
	}

	@Override
	public void sendGUINetworkData(Container cont, ICrafting craft) {
		craft.sendProgressBarUpdate(cont, 0, isRunning() ? 1 : 0);
	}

	@Override
	public void getGUINetworkData(int id, int value) {
		if(id == 0)isRuning = value == 1;
	}

	@Override
	public IModuleCPU getCPU() {
		return procesor;
	}

	@Override
	public IModuleMemoryController getMemory() {
		return memory;
	}
	
	public InventoryComponent getInv() {
		return inv;
	}

	public boolean isRunning() {
		if(!worldObj.isRemote)isRuning = motherboard.isActive() && procesor.isRunning();
		return isRuning;
	}

	@Override
	public TileEntity getParent() {
		return this;
	}

	@Override
	public IPeripheral[] getPeripherals() {
		return new IPeripheral[]{motherboard, hardDrive, floppyDrive};
	}
}
