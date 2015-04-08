// Date: 25/10/2014 14:03:27
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

public class ModelPumpHead extends ModelBase
{
  //fields
    ModelRenderer pole2;
    ModelRenderer con;
    ModelRenderer pole;
    ModelRenderer peso;
    ModelRenderer con2;
    ModelRenderer box;
  
  public ModelPumpHead()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      pole2 = new ModelRenderer(this, 0, 43);
      pole2.addBox(-2F, -16F, -2F, 4, 12, 4);
      pole2.setRotationPoint(0F, 16F, 0F);
      pole2.setTextureSize(64, 64);
      pole2.mirror = true;
      setRotation(pole2, 0F, 0F, 0F);
      con = new ModelRenderer(this, 0, 40);
      con.addBox(-2F, -1F, -0.5F, 4, 1, 1);
      con.setRotationPoint(0F, 0F, 0F);
      con.setTextureSize(64, 64);
      con.mirror = true;
      setRotation(con, 0F, 0F, 0F);
      pole = new ModelRenderer(this, 0, 32);
      pole.addBox(-2F, -3F, -16F, 4, 4, 28);
      pole.setRotationPoint(0F, -2F, 0F);
      pole.setTextureSize(64, 64);
      pole.mirror = true;
      setRotation(pole, 0F, 0F, 0F);
      peso = new ModelRenderer(this, 36, 24);
      peso.addBox(-2F, -8F, 12F, 4, 14, 4);
      peso.setRotationPoint(0F, -2F, 0F);
      peso.setTextureSize(64, 64);
      peso.mirror = true;
      setRotation(peso, 0F, 0F, 0F);
      con2 = new ModelRenderer(this, 0, 36);
      con2.addBox(-6F, -1.5F, -17F, 12, 1, 1);
      con2.setRotationPoint(0F, -2F, 0F);
      con2.setTextureSize(64, 64);
      con2.mirror = true;
      setRotation(con2, 0F, 0F, 0F);
      box = new ModelRenderer(this, 0, 0);
      box.addBox(-8F, -4F, -6F, 16, 12, 12);
      box.setRotationPoint(0F, 16F, 0F);
      box.setTextureSize(64, 64);
      box.mirror = true;
      setRotation(box, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    pole2.render(f5);
    con.render(f5);
    pole.render(f5);
    peso.render(f5);
    con2.render(f5);
    box.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void renderStatic(float f5){
	  pole2.render(f5);
	  con.render(f5);
//	  pole.render(f5);
//	  peso.render(f5);
//	  con2.render(f5);
	  box.render(f5);
  }
  
  public void renderDynamic(float f5,float animationMoment){
	  float perone = animationMoment/1000;
	  float x = (float) (15*Math.cos(Math.toRadians(360*perone)));
	  GL11.glPushMatrix();
	  pole.rotateAngleX = (float) Math.toRadians(x);
	  pole.render(f5);
	  peso.rotateAngleX = (float) Math.toRadians(x);
	  peso.render(f5);
	  con2.rotateAngleX = (float) Math.toRadians(x);
	  con2.render(f5);
	  GL11.glPopMatrix();
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity t)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,t);
  }

}
