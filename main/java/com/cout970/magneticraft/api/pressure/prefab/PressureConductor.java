package com.cout970.magneticraft.api.pressure.prefab;

import com.cout970.magneticraft.api.pressure.IPressureConductor;
import com.cout970.magneticraft.api.util.ConnectionClass;
import com.cout970.magneticraft.api.util.EnergyConversor;
import com.cout970.magneticraft.api.util.IConnectable;
import com.cout970.magneticraft.api.util.VecInt;
import com.cout970.magneticraft.api.util.VecIntUtil;
import com.cout970.magneticraft.util.Log;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

public class PressureConductor implements IPressureConductor{

	protected TileEntity parent;
	protected double volume;
	protected double temperature;
	protected long moles;
	protected Fluid currentGas;
	
	public PressureConductor(TileEntity t, double volume){
		parent = t;
		this.volume = volume;
	}
	
	@Override
	public TileEntity getParent() {
		return parent;
	}

	@Override
	public void iterate() {
		//TODO
		Log.debug(EnergyConversor.PAtoBAR(getPressure())+"\t"+getTemperature()+"\t"+getMoles()+"\t"+EnergyConversor.MOLtoMB(getMoles()));
	}

	@Override
	public VecInt[] getValidConnections() {
		return VecIntUtil.FORGE_DIRECTIONS;
	}

	@Override
	public boolean isAbleToConnect(IConnectable cond, VecInt dir) {
		return true;
	}

	@Override
	public ConnectionClass getConnectionClass(VecInt v) {
		return ConnectionClass.FULL_BLOCK;
	}

	@Override
	public void save(NBTTagCompound nbt) {
		nbt.setDouble("vol", volume);
		nbt.setDouble("temp", temperature);
		nbt.setLong("mol", moles);
	}

	@Override
	public void load(NBTTagCompound nbt) {
		volume = nbt.getDouble("vol");
		temperature = nbt.getDouble("temp");
		moles = nbt.getLong("mol");
	}

	@Override
	public double getVolume() {
		return volume;
	}

	@Override
	public void setVolume(double vol) {
		volume = vol;
	}

	@Override
	public double getPressure() {
		return ((moles*temperature*R)/(volume/1000D))*1000;
	}

	@Override
	public double getTemperature() {
		return temperature;
	}

	@Override
	public void setTemperature(double temp) {
		temperature = temp;
	}

	@Override
	public void onBlockExplode() {}

	@Override
	public long getMoles() {
		return moles;
	}

	@Override
	public void setMoles(long moles) {
		this.moles = moles;
	}

	@Override
	public int applyGas(FluidStack gas) {
		if(gas == null)return 0;
		if(gas.amount == 0)return 0;
		if(!gas.getFluid().isGaseous())return 0;
		if(currentGas == null || gas.getFluid().equals(currentGas)){
			currentGas = gas.getFluid();
			temperature = currentGas.getTemperature();
			moles += EnergyConversor.MBtoMOL(gas.amount);
//			Log.debug("adding: "+EnergyConversor.MBtoMOL(gas.amount)+", "+temp1);
			return gas.amount;
		}
		return 0;
	}

	@Override
	public FluidStack drainGas(int amount) {
		if(currentGas == null)return null;
		if(amount <= 0)return null;
		int mB = (int) Math.min(amount, EnergyConversor.MOLtoMB(moles));
		if(mB > 0){
			moles -=  EnergyConversor.MBtoMOL(mB);
//			Log.debug("extracting: "+EnergyConversor.MBtoMOL(mB)+", "+temp2);
			
			return new FluidStack(currentGas, mB);
		}
		return null;
	}

	@Override
	public double getMaxPressure() {
		return EnergyConversor.BARtoPA(200);
	}

	@Override
	public Fluid getFluid() {
		return currentGas;
	}
}