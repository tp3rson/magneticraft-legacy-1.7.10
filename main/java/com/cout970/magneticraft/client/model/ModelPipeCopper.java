package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPipeCopper extends ModelBase
{
	//fields
	ModelRenderer UpRF;
	ModelRenderer UpFL;
	ModelRenderer UpLB;
	ModelRenderer UpRB;
	ModelRenderer DownFL;
	ModelRenderer DownLB;
	ModelRenderer DownBR;
	ModelRenderer DownRF;
	ModelRenderer FrontRD;
	ModelRenderer FrontDL;
	ModelRenderer FrontLU;
	ModelRenderer FrontUR;
	ModelRenderer BackLD;
	ModelRenderer BackDR;
	ModelRenderer BackRU;
	ModelRenderer BackUL;
	ModelRenderer RightBD;
	ModelRenderer RightDF;
	ModelRenderer RightUB;
	ModelRenderer RightFU;
	ModelRenderer LeftFD;
	ModelRenderer LeftDB;
	ModelRenderer LeftUF;
	ModelRenderer LeftBU;
	ModelRenderer ConUp;
	ModelRenderer ConDown;
	ModelRenderer conFront;
	ModelRenderer conBack;
	ModelRenderer conRight;
	ModelRenderer conLeft;

	public ModelPipeCopper()
	{
		textureWidth = 64;
		textureHeight = 32;

		UpRF = new ModelRenderer(this, 0, 16);
		UpRF.addBox(-3F, -8F, -3F, 1, 5, 1);
		UpRF.setRotationPoint(0F, 16F, 0F);
		UpRF.setTextureSize(64, 32);
		UpRF.mirror = true;
		setRotation(UpRF, 0F, 0F, 0F);
		UpFL = new ModelRenderer(this, 0, 16);
		UpFL.addBox(2F, -8F, -3F, 1, 5, 1);
		UpFL.setRotationPoint(0F, 16F, 0F);
		UpFL.setTextureSize(64, 32);
		UpFL.mirror = true;
		setRotation(UpFL, 0F, 0F, 0F);
		UpLB = new ModelRenderer(this, 0, 16);
		UpLB.addBox(2F, -8F, 2F, 1, 5, 1);
		UpLB.setRotationPoint(0F, 16F, 0F);
		UpLB.setTextureSize(64, 32);
		UpLB.mirror = true;
		setRotation(UpLB, 0F, 0F, 0F);
		UpRB = new ModelRenderer(this, 0, 16);
		UpRB.addBox(-3F, -8F, 2F, 1, 5, 1);
		UpRB.setRotationPoint(0F, 16F, 0F);
		UpRB.setTextureSize(64, 32);
		UpRB.mirror = true;
		setRotation(UpRB, 0F, 0F, 0F);
		DownFL = new ModelRenderer(this, 0, 10);
		DownFL.addBox(2F, 3F, -3F, 1, 5, 1);
		DownFL.setRotationPoint(0F, 16F, 0F);
		DownFL.setTextureSize(64, 32);
		DownFL.mirror = true;
		setRotation(DownFL, 0F, 0F, 0F);
		DownLB = new ModelRenderer(this, 0, 10);
		DownLB.addBox(2F, 3F, 2F, 1, 5, 1);
		DownLB.setRotationPoint(0F, 16F, 0F);
		DownLB.setTextureSize(64, 32);
		DownLB.mirror = true;
		setRotation(DownLB, 0F, 0F, 0F);
		DownBR = new ModelRenderer(this, 0, 10);
		DownBR.addBox(-3F, 3F, 2F, 1, 5, 1);
		DownBR.setRotationPoint(0F, 16F, 0F);
		DownBR.setTextureSize(64, 32);
		DownBR.mirror = true;
		setRotation(DownBR, 0F, 0F, 0F);
		DownRF = new ModelRenderer(this, 0, 10);
		DownRF.addBox(-3F, 3F, -3F, 1, 5, 1);
		DownRF.setRotationPoint(0F, 16F, 0F);
		DownRF.setTextureSize(64, 32);
		DownRF.mirror = true;
		setRotation(DownRF, 0F, 0F, 0F);
		FrontRD = new ModelRenderer(this, 5, 16);
		FrontRD.addBox(-3F, 2F, -8F, 1, 1, 5);
		FrontRD.setRotationPoint(0F, 16F, 0F);
		FrontRD.setTextureSize(64, 32);
		FrontRD.mirror = true;
		setRotation(FrontRD, 0F, 0F, 0F);
		FrontDL = new ModelRenderer(this, 5, 16);
		FrontDL.addBox(2F, 2F, -8F, 1, 1, 5);
		FrontDL.setRotationPoint(0F, 16F, 0F);
		FrontDL.setTextureSize(64, 32);
		FrontDL.mirror = true;
		setRotation(FrontDL, 0F, 0F, 0F);
		FrontLU = new ModelRenderer(this, 5, 16);
		FrontLU.addBox(2F, -3F, -8F, 1, 1, 5);
		FrontLU.setRotationPoint(0F, 16F, 0F);
		FrontLU.setTextureSize(64, 32);
		FrontLU.mirror = true;
		setRotation(FrontLU, 0F, 0F, 0F);
		FrontUR = new ModelRenderer(this, 5, 16);
		FrontUR.addBox(-3F, -3F, -8F, 1, 1, 5);
		FrontUR.setRotationPoint(0F, 16F, 0F);
		FrontUR.setTextureSize(64, 32);
		FrontUR.mirror = true;
		setRotation(FrontUR, 0F, 0F, 0F);
		BackLD = new ModelRenderer(this, 5, 10);
		BackLD.addBox(2F, 2F, 3F, 1, 1, 5);
		BackLD.setRotationPoint(0F, 16F, 0F);
		BackLD.setTextureSize(64, 32);
		BackLD.mirror = true;
		setRotation(BackLD, 0F, 0F, 0F);
		BackDR = new ModelRenderer(this, 5, 10);
		BackDR.addBox(-3F, 2F, 3F, 1, 1, 5);
		BackDR.setRotationPoint(0F, 16F, 0F);
		BackDR.setTextureSize(64, 32);
		BackDR.mirror = true;
		setRotation(BackDR, 0F, 0F, 0F);
		BackRU = new ModelRenderer(this, 5, 10);
		BackRU.addBox(-3F, -3F, 3F, 1, 1, 5);
		BackRU.setRotationPoint(0F, 16F, 0F);
		BackRU.setTextureSize(64, 32);
		BackRU.mirror = true;
		setRotation(BackRU, 0F, 0F, 0F);
		BackUL = new ModelRenderer(this, 5, 10);
		BackUL.addBox(2F, -3F, 3F, 1, 1, 5);
		BackUL.setRotationPoint(0F, 16F, 0F);
		BackUL.setTextureSize(64, 32);
		BackUL.mirror = true;
		setRotation(BackUL, 0F, 0F, 0F);
		RightBD = new ModelRenderer(this, 0, 7);
		RightBD.addBox(-8F, 2F, 2F, 5, 1, 1);
		RightBD.setRotationPoint(0F, 16F, 0F);
		RightBD.setTextureSize(64, 32);
		RightBD.mirror = true;
		setRotation(RightBD, 0F, 0F, 0F);
		RightDF = new ModelRenderer(this, 0, 7);
		RightDF.addBox(-8F, 2F, -3F, 5, 1, 1);
		RightDF.setRotationPoint(0F, 16F, 0F);
		RightDF.setTextureSize(64, 32);
		RightDF.mirror = true;
		setRotation(RightDF, 0F, 0F, 0F);
		RightUB = new ModelRenderer(this, 0, 7);
		RightUB.addBox(-8F, -3F, 2F, 5, 1, 1);
		RightUB.setRotationPoint(0F, 16F, 0F);
		RightUB.setTextureSize(64, 32);
		RightUB.mirror = true;
		setRotation(RightUB, 0F, 0F, 0F);
		RightFU = new ModelRenderer(this, 0, 7);
		RightFU.addBox(-8F, -3F, -3F, 5, 1, 1);
		RightFU.setRotationPoint(0F, 16F, 0F);
		RightFU.setTextureSize(64, 32);
		RightFU.mirror = true;
		setRotation(RightFU, 0F, 0F, 0F);
		LeftFD = new ModelRenderer(this, 0, 0);
		LeftFD.addBox(3F, 2F, -3F, 5, 1, 1);
		LeftFD.setRotationPoint(0F, 16F, 0F);
		LeftFD.setTextureSize(64, 32);
		LeftFD.mirror = true;
		setRotation(LeftFD, 0F, 0F, 0F);
		LeftDB = new ModelRenderer(this, 0, 0);
		LeftDB.addBox(3F, 2F, 2F, 5, 1, 1);
		LeftDB.setRotationPoint(0F, 16F, 0F);
		LeftDB.setTextureSize(64, 32);
		LeftDB.mirror = true;
		setRotation(LeftDB, 0F, 0F, 0F);
		LeftUF = new ModelRenderer(this, 0, 0);
		LeftUF.addBox(3F, -3F, -3F, 5, 1, 1);
		LeftUF.setRotationPoint(0F, 16F, 0F);
		LeftUF.setTextureSize(64, 32);
		LeftUF.mirror = true;
		setRotation(LeftUF, 0F, 0F, 0F);
		LeftBU = new ModelRenderer(this, 0, 0);
		LeftBU.addBox(3F, -3F, 2F, 5, 1, 1);
		LeftBU.setRotationPoint(0F, 16F, 0F);
		LeftBU.setTextureSize(64, 32);
		LeftBU.mirror = true;
		setRotation(LeftBU, 0F, 0F, 0F);
		ConUp = new ModelRenderer(this, 0, 22);
		ConUp.addBox(-4F, -8F, -4F, 8, 2, 8);
		ConUp.setRotationPoint(0F, 16F, 0F);
		ConUp.setTextureSize(64, 32);
		ConUp.mirror = true;
		setRotation(ConUp, 0F, 0F, 0F);
		ConDown = new ModelRenderer(this, 0, 22);
		ConDown.addBox(-4F, 6F, -4F, 8, 2, 8);
		ConDown.setRotationPoint(0F, 16F, 0F);
		ConDown.setTextureSize(64, 32);
		ConDown.mirror = true;
		setRotation(ConDown, 0F, 0F, 0F);
		conFront = new ModelRenderer(this, 32, 22);
		conFront.addBox(-4F, -4F, -8F, 8, 8, 2);
		conFront.setRotationPoint(0F, 16F, 0F);
		conFront.setTextureSize(64, 32);
		conFront.mirror = true;
		setRotation(conFront, 0F, 0F, 0F);
		conBack = new ModelRenderer(this, 32, 22);
		conBack.addBox(-4F, -4F, 6F, 8, 8, 2);
		conBack.setRotationPoint(0F, 16F, 0F);
		conBack.setTextureSize(64, 32);
		conBack.mirror = true;
		setRotation(conBack, 0F, 0F, 0F);
		conRight = new ModelRenderer(this, 32, 0);
		conRight.addBox(-8F, -4F, -4F, 2, 8, 8);
		conRight.setRotationPoint(0F, 16F, 0F);
		conRight.setTextureSize(64, 32);
		conRight.mirror = true;
		setRotation(conRight, 0F, 0F, 0F);
		conLeft = new ModelRenderer(this, 32, 0);
		conLeft.addBox(6F, -4F, -4F, 2, 8, 8);
		conLeft.setRotationPoint(0F, 16F, 0F);
		conLeft.setTextureSize(64, 32);
		conLeft.mirror = true;
		setRotation(conLeft, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		UpRF.render(f5);
		UpFL.render(f5);
		UpLB.render(f5);
		UpRB.render(f5);
		DownFL.render(f5);
		DownLB.render(f5);
		DownBR.render(f5);
		DownRF.render(f5);
		FrontRD.render(f5);
		FrontDL.render(f5);
		FrontLU.render(f5);
		FrontUR.render(f5);
		BackLD.render(f5);
		BackDR.render(f5);
		BackRU.render(f5);
		BackUL.render(f5);
		RightBD.render(f5);
		RightDF.render(f5);
		RightUB.render(f5);
		RightFU.render(f5);
		LeftFD.render(f5);
		LeftDB.render(f5);
		LeftUF.render(f5);
		LeftBU.render(f5);
		ConUp.render(f5);
		ConDown.render(f5);
		conFront.render(f5);
		conBack.render(f5);
		conRight.render(f5);
		conLeft.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void render(float f5, boolean[] a) {
		if(a == null)return;

		if(a[0])DownFL.render(f5);
		if(a[0])DownLB.render(f5);
		if(a[0])DownBR.render(f5);
		if(a[0])DownRF.render(f5);

		if(a[1])UpRF.render(f5);
		if(a[1])UpFL.render(f5);
		if(a[1])UpLB.render(f5);
		if(a[1])UpRB.render(f5);

		if(a[2])FrontRD.render(f5);
		if(a[2])FrontDL.render(f5);
		if(a[2])FrontLU.render(f5);
		if(a[2])FrontUR.render(f5);

		if(a[3])BackLD.render(f5);
		if(a[3])BackDR.render(f5);
		if(a[3])BackRU.render(f5);
		if(a[3])BackUL.render(f5);

		if(a[4])LeftFD.render(f5);
		if(a[4])LeftDB.render(f5);
		if(a[4])LeftUF.render(f5);
		if(a[4])LeftBU.render(f5);

		if(a[5])RightBD.render(f5);
		if(a[5])RightDF.render(f5);
		if(a[5])RightUB.render(f5);
		if(a[5])RightFU.render(f5);
	}

	public void render(float f5, boolean[] b, boolean c) {
		if(b == null)return;
		if(b[1])ConDown.render(f5);
		if(b[0])ConUp.render(f5);
		if(b[3])conFront.render(f5);
		if(b[2])conBack.render(f5);
		if(b[5])conLeft.render(f5);
		if(b[4])conRight.render(f5);
	}

}
