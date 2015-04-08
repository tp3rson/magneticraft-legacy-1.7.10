package com.cout970.magneticraft.util.fluid;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.IFluidTank;

import com.cout970.magneticraft.api.util.MgDirection;

public interface IFluidTransport {

	TileEntity getTileEntity();

	void setNetwork(FluidNetwork fluidNetwork);

	void onNetworkUpdate();

	FluidNetwork getNetwork();
	
	IFluidTank getTank();
	
	boolean canConectOnSide(MgDirection dir);

}
