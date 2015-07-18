package com.cout970.magneticraft.items;

import java.io.File;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.cout970.magneticraft.api.computer.IStorageDevice;
import com.cout970.magneticraft.api.computer.impl.ComputerUtils;
import com.cout970.magneticraft.api.util.NBTUtils;
import com.cout970.magneticraft.tabs.CreativeTabsMg;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHardDrive extends ItemBasic implements IStorageDevice{

	public static final int DISK_SIZE = 0x100000; //1024kB
	
	public ItemHardDrive(String unlocalizedname) {
		super(unlocalizedname);
		setCreativeTab(CreativeTabsMg.InformationAgeTab);
	}

	@Override
	public File getAsociateFile(ItemStack i) {
		NBTUtils.sanityCheck(i);
		return ComputerUtils.getFileFromItemStack(i);
	}

	@Override
	public String getDiskLabel(ItemStack i) {
		return ""+NBTUtils.getString("Label", i);
	}

	@Override
	public String getSerialNumber(ItemStack i) {
		return ""+NBTUtils.getString("SerialNumber", i);
	}

	@Override
	public int getSize(ItemStack i) {
		return DISK_SIZE;
	}

	@Override
	public void setDiskLabel(ItemStack i, String label) {
		NBTUtils.setString("Label", i, label);
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack item, EntityPlayer player, List list, boolean flag) {
		super.addInformation(item, player, list, flag);
		list.add(ItemBlockMg.format+(int)(DISK_SIZE/1024)+"kB of storage");
	}

	@Override
	public int getAccessTime(ItemStack i) {
		return 0;
	}

	@Override
	public boolean isHardDrive(ItemStack i) {
		return true;
	}

	@Override
	public boolean isFloppyDrive(ItemStack i) {
		return false;
	}
}
