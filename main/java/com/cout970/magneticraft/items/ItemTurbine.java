package com.cout970.magneticraft.items;

import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.cout970.magneticraft.api.util.IRenderizable;
import com.cout970.magneticraft.api.util.IWindTurbine;
import com.cout970.magneticraft.client.model.ModelWindMillBig;
import com.cout970.magneticraft.client.tilerender.ModelTextures;
import com.cout970.magneticraft.tabs.CreativeTabsMg;

public class ItemTurbine extends ItemBasic implements IWindTurbine{

	private int ID;
	private int height;
	private int lenght;
	private double potency;
	private float scale;

	public ItemTurbine(String n,int id, int h, int l,double p,float s) {
		super(n);
		ID = id;
		height = h;
		lenght = l;
		potency = p;
		scale = s;
		setCreativeTab(CreativeTabsMg.ElectricalAgeTab);
	}

	@Override
	public int getID() {
		return ID;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getLenght() {
		return lenght;
	}

	@Override
	public double getPotency() {
		return potency;
	}

	@Override
	public float getScale() {
		return scale;
	}

	@Override
	public IRenderizable initRender() {
		return new IRenderizable() {
			
			private ModelWindMillBig big = new ModelWindMillBig();
			
			@Override
			public void renderStatic(float f5) {}
			
			@Override
			public void renderDynamic(float f5, float additionalData) {
				float p = getScale();
				GL11.glScalef(p, 1, p);
				big.renderStatic(f5);
			}
			
			@Override
			public ResourceLocation getTexture() {
				return ModelTextures.WIND_TURBINE_ITEM;
			}
		};
	}

}
