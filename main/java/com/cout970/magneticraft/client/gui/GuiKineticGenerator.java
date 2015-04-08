package com.cout970.magneticraft.client.gui;

import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import com.cout970.magneticraft.Magneticraft;
import com.cout970.magneticraft.client.gui.component.CompBackground;
import com.cout970.magneticraft.client.gui.component.CompButtonRedstoneControl;
import com.cout970.magneticraft.client.gui.component.CompEnergyBarMediumVoltage;
import com.cout970.magneticraft.client.gui.component.CompProductionBar;
import com.cout970.magneticraft.client.gui.component.CompRFBar;
import com.cout970.magneticraft.client.gui.component.GuiPoint;

public class GuiKineticGenerator extends GuiBasic{

	public GuiKineticGenerator(Container c, TileEntity tile) {
		super(c, tile);
	}

	@Override
	public void initComponenets() {
		comp.add(new CompBackground(new ResourceLocation(Magneticraft.NAME.toLowerCase()+":textures/gui/kinetic.png")));
		comp.add(new CompEnergyBarMediumVoltage(new ResourceLocation(Magneticraft.NAME.toLowerCase()+":textures/gui/energybar2.png"),new GuiPoint(23,16)));		
		comp.add(new CompRFBar(new ResourceLocation(Magneticraft.NAME.toLowerCase()+":textures/gui/rfbar.png"),new GuiPoint(42,23)));
		comp.add(new CompProductionBar("RF/t",new ResourceLocation(Magneticraft.NAME.toLowerCase()+":textures/gui/productionbar.png"),new GuiPoint(32,20)));
		comp.add(new CompButtonRedstoneControl(new GuiPoint(150, 8)));
	}
}
