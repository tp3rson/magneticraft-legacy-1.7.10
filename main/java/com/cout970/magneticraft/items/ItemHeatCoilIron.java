package com.cout970.magneticraft.items;

import com.cout970.magneticraft.api.tool.IFurnaceCoil;
import com.cout970.magneticraft.tabs.CreativeTabsMg;

public class ItemHeatCoilIron extends ItemBasic implements IFurnaceCoil{

	public ItemHeatCoilIron(String unlocalizedname) {
		super(unlocalizedname);
		setCreativeTab(CreativeTabsMg.ElectricalAgeTab);
	}

	@Override
	public int getCookTime() {
		return 60;
	}

	@Override
	public double getElectricConsumption() {
		return 3.4D;
	}

}
