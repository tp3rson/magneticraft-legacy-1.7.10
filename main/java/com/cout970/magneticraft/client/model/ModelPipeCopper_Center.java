package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPipeCopper_Center extends ModelBase
{
	//fields
	ModelRenderer UpRF;
	ModelRenderer UpFL;
	ModelRenderer UpLB;
	ModelRenderer UpBR;
	ModelRenderer UbarL;
	ModelRenderer UbarR;
	ModelRenderer UbarB;
	ModelRenderer UbarF;
	ModelRenderer HbarRF;
	ModelRenderer HbarBR;
	ModelRenderer HbarLB;
	ModelRenderer HbarFL;
	ModelRenderer DownRF;
	ModelRenderer DownBR;
	ModelRenderer DownLB;
	ModelRenderer DownFL;
	ModelRenderer DbarF;
	ModelRenderer DbarB;
	ModelRenderer DbarL;
	ModelRenderer DbarR;

	public ModelPipeCopper_Center()
	{
		textureWidth = 10;
		textureHeight = 32;

		UpRF = new ModelRenderer(this, 0, 0);
		UpRF.addBox(-3F, -3F, -3F, 1, 1, 1);
		UpRF.setRotationPoint(0F, 16F, 0F);
		UpRF.setTextureSize(10, 32);
		UpRF.mirror = true;
		setRotation(UpRF, 0F, 0F, 0F);
		UpFL = new ModelRenderer(this, 0, 0);
		UpFL.addBox(2F, -3F, -3F, 1, 1, 1);
		UpFL.setRotationPoint(0F, 16F, 0F);
		UpFL.setTextureSize(10, 32);
		UpFL.mirror = true;
		setRotation(UpFL, 0F, 0F, 0F);
		UpLB = new ModelRenderer(this, 0, 0);
		UpLB.addBox(2F, -3F, 2F, 1, 1, 1);
		UpLB.setRotationPoint(0F, 16F, 0F);
		UpLB.setTextureSize(10, 32);
		UpLB.mirror = true;
		setRotation(UpLB, 0F, 0F, 0F);
		UpBR = new ModelRenderer(this, 0, 0);
		UpBR.addBox(-3F, -3F, 2F, 1, 1, 1);
		UpBR.setRotationPoint(0F, 16F, 0F);
		UpBR.setTextureSize(10, 32);
		UpBR.mirror = true;
		setRotation(UpBR, 0F, 0F, 0F);
		UbarL = new ModelRenderer(this, 0, 27);
		UbarL.addBox(2F, -3F, -2F, 1, 1, 4);
		UbarL.setRotationPoint(0F, 16F, 0F);
		UbarL.setTextureSize(10, 32);
		UbarL.mirror = true;
		setRotation(UbarL, 0F, 0F, 0F);
		UbarR = new ModelRenderer(this, 0, 27);
		UbarR.addBox(-3F, -3F, -2F, 1, 1, 4);
		UbarR.setRotationPoint(0F, 16F, 0F);
		UbarR.setTextureSize(10, 32);
		UbarR.mirror = true;
		setRotation(UbarR, 0F, 0F, 0F);
		UbarB = new ModelRenderer(this, 0, 25);
		UbarB.addBox(-2F, -3F, 2F, 4, 1, 1);
		UbarB.setRotationPoint(0F, 16F, 0F);
		UbarB.setTextureSize(10, 32);
		UbarB.mirror = true;
		setRotation(UbarB, 0F, 0F, 0F);
		UbarF = new ModelRenderer(this, 0, 25);
		UbarF.addBox(-2F, -3F, -3F, 4, 1, 1);
		UbarF.setRotationPoint(0F, 16F, 0F);
		UbarF.setTextureSize(10, 32);
		UbarF.mirror = true;
		setRotation(UbarF, 0F, 0F, 0F);
		HbarRF = new ModelRenderer(this, 0, 20);
		HbarRF.addBox(-3F, -2F, -3F, 1, 4, 1);
		HbarRF.setRotationPoint(0F, 16F, 0F);
		HbarRF.setTextureSize(10, 32);
		HbarRF.mirror = true;
		setRotation(HbarRF, 0F, 0F, 0F);
		HbarBR = new ModelRenderer(this, 0, 20);
		HbarBR.addBox(-3F, -2F, 2F, 1, 4, 1);
		HbarBR.setRotationPoint(0F, 16F, 0F);
		HbarBR.setTextureSize(10, 32);
		HbarBR.mirror = true;
		setRotation(HbarBR, 0F, 0F, 0F);
		HbarLB = new ModelRenderer(this, 0, 20);
		HbarLB.addBox(2F, -2F, 2F, 1, 4, 1);
		HbarLB.setRotationPoint(0F, 16F, 0F);
		HbarLB.setTextureSize(10, 32);
		HbarLB.mirror = true;
		setRotation(HbarLB, 0F, 0F, 0F);
		HbarFL = new ModelRenderer(this, 0, 20);
		HbarFL.addBox(2F, -2F, -3F, 1, 4, 1);
		HbarFL.setRotationPoint(0F, 16F, 0F);
		HbarFL.setTextureSize(10, 32);
		HbarFL.mirror = true;
		setRotation(HbarFL, 0F, 0F, 0F);
		DownRF = new ModelRenderer(this, 0, 0);
		DownRF.addBox(-3F, 2F, -3F, 1, 1, 1);
		DownRF.setRotationPoint(0F, 16F, 0F);
		DownRF.setTextureSize(10, 32);
		DownRF.mirror = true;
		setRotation(DownRF, 0F, 0F, 0F);
		DownBR = new ModelRenderer(this, 0, 0);
		DownBR.addBox(-3F, 2F, 2F, 1, 1, 1);
		DownBR.setRotationPoint(0F, 16F, 0F);
		DownBR.setTextureSize(10, 32);
		DownBR.mirror = true;
		setRotation(DownBR, 0F, 0F, 0F);
		DownLB = new ModelRenderer(this, 0, 0);
		DownLB.addBox(2F, 2F, 2F, 1, 1, 1);
		DownLB.setRotationPoint(0F, 16F, 0F);
		DownLB.setTextureSize(10, 32);
		DownLB.mirror = true;
		setRotation(DownLB, 0F, 0F, 0F);
		DownFL = new ModelRenderer(this, 0, 0);
		DownFL.addBox(2F, 2F, -3F, 1, 1, 1);
		DownFL.setRotationPoint(0F, 16F, 0F);
		DownFL.setTextureSize(10, 32);
		DownFL.mirror = true;
		setRotation(DownFL, 0F, 0F, 0F);
		DbarF = new ModelRenderer(this, 0, 18);
		DbarF.addBox(-2F, 2F, -3F, 4, 1, 1);
		DbarF.setRotationPoint(0F, 16F, 0F);
		DbarF.setTextureSize(10, 32);
		DbarF.mirror = true;
		setRotation(DbarF, 0F, 0F, 0F);
		DbarB = new ModelRenderer(this, 0, 18);
		DbarB.addBox(-2F, 2F, 2F, 4, 1, 1);
		DbarB.setRotationPoint(0F, 16F, 0F);
		DbarB.setTextureSize(10, 32);
		DbarB.mirror = true;
		setRotation(DbarB, 0F, 0F, 0F);
		DbarL = new ModelRenderer(this, 0, 13);
		DbarL.addBox(2F, 2F, -2F, 1, 1, 4);
		DbarL.setRotationPoint(0F, 16F, 0F);
		DbarL.setTextureSize(10, 32);
		DbarL.mirror = true;
		setRotation(DbarL, 0F, 0F, 0F);
		DbarR = new ModelRenderer(this, 0, 13);
		DbarR.addBox(-3F, 2F, -2F, 1, 1, 4);
		DbarR.setRotationPoint(0F, 16F, 0F);
		DbarR.setTextureSize(10, 32);
		DbarR.mirror = true;
		setRotation(DbarR, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		UpRF.render(f5);
		UpFL.render(f5);
		UpLB.render(f5);
		UpBR.render(f5);
		UbarL.render(f5);
		UbarR.render(f5);
		UbarB.render(f5);
		UbarF.render(f5);
		HbarRF.render(f5);
		HbarBR.render(f5);
		HbarLB.render(f5);
		HbarFL.render(f5);
		DownRF.render(f5);
		DownBR.render(f5);
		DownLB.render(f5);
		DownFL.render(f5);
		DbarF.render(f5);
		DbarB.render(f5);
		DbarL.render(f5);
		DbarR.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}


	public void render(float f5, boolean[] a) {
		if(a==null)return;	
		UpRF.render(f5);
		UpFL.render(f5);
		UpLB.render(f5);
		UpBR.render(f5);
		if(a[1] && a[4])UbarL.render(f5);
		if(a[1] && a[5])UbarR.render(f5);
		if(a[1] && a[3])UbarB.render(f5);
		if(a[1] && a[2])UbarF.render(f5);
		if(a[2] && a[5])HbarRF.render(f5);
		if(a[3] && a[5])HbarBR.render(f5);
		if(a[3] && a[4])HbarLB.render(f5);
		if(a[2] && a[4])HbarFL.render(f5);
		DownRF.render(f5);
		DownBR.render(f5);
		DownLB.render(f5);
		DownFL.render(f5);
		if(a[0] && a[2])DbarF.render(f5);
		if(a[0] && a[3])DbarB.render(f5);
		if(a[0] && a[4])DbarL.render(f5);
		if(a[0] && a[5])DbarR.render(f5);
	}

}
