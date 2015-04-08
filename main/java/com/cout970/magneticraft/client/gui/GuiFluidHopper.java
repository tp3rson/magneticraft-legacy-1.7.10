package com.cout970.magneticraft.client.gui;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import com.cout970.magneticraft.Magneticraft;
import com.cout970.magneticraft.client.gui.component.CompBackground;
import com.cout970.magneticraft.client.gui.component.CompFluidRender;
import com.cout970.magneticraft.client.gui.component.GuiPoint;
import com.cout970.magneticraft.tileentity.TileFluidHopper;

public class GuiFluidHopper extends GuiBasic{

	public GuiFluidHopper(Container c, TileEntity tile) {
		super(c, tile);
	}

	@Override
	public void initComponenets() {
		comp.add(new CompBackground(new ResourceLocation(Magneticraft.NAME.toLowerCase()+":textures/gui/hopper.png")));
		comp.add(new CompFluidRender(((TileFluidHopper)tile).tank, new GuiPoint(81, 25), new GuiPoint(99, 64), new ResourceLocation(Magneticraft.NAME.toLowerCase()+":textures/gui/tank.png")));
	}

}
