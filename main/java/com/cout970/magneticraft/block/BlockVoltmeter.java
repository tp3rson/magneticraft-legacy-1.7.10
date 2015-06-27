package com.cout970.magneticraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.cout970.magneticraft.tileentity.TileVoltmeter;

public class BlockVoltmeter extends BlockMg{

	public BlockVoltmeter() {
		super(Material.iron);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileVoltmeter();
	}

	@Override
	public String[] getTextures() {
		return new String[]{"block_voltmeter"};
	}

	@Override
	public String getName() {
		return "block_voltmeter";
	}

}
