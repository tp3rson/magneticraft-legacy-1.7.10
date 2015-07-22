package com.cout970.magneticraft;

import com.cout970.magneticraft.messages.MessageClientCrafterUpdate;
import com.cout970.magneticraft.messages.MessageClientStream;
import com.cout970.magneticraft.messages.MessageGuiClick;
import com.cout970.magneticraft.messages.MessageNBTUpdate;
import com.cout970.magneticraft.messages.MessageRedstoneControlUpdate;
import com.cout970.magneticraft.messages.MessageRedstoneStateUpdate;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class ManagerNetwork {

	public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("magneticraft");
	
	public static void registerMessages(){
		INSTANCE.registerMessage(MessageNBTUpdate.class, MessageNBTUpdate.class, 0, Side.CLIENT);
		INSTANCE.registerMessage(MessageRedstoneControlUpdate.class, MessageRedstoneControlUpdate.class, 1, Side.SERVER);
		INSTANCE.registerMessage(MessageRedstoneStateUpdate.class, MessageRedstoneStateUpdate.class, 2, Side.SERVER);
		INSTANCE.registerMessage(MessageClientStream.class, MessageClientStream.class, 3, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiClick.class, MessageGuiClick.class, 4, Side.SERVER);
		INSTANCE.registerMessage(MessageClientCrafterUpdate.class, MessageClientCrafterUpdate.class, 5, Side.SERVER);
	}
}
