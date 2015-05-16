package com.cout970.magneticraft.api.computer;

import com.cout970.magneticraft.api.util.MgDirection;

public interface IPeripheralBus {

	public int getAddress(MgDirection side);
	public void setAddress(int address,MgDirection side);
	
	public boolean isOnline();
}
