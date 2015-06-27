// Date: 20/06/2015 16:06:29
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelJackHammer extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape9;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
  
  public ModelJackHammer()
  {
    textureWidth = 34;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 14);
      Shape1.addBox(-1.5F, -7F, -1.5F, 3, 9, 3);
      Shape1.setRotationPoint(0F, 16F, 0F);
      Shape1.setTextureSize(34, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(-3.5F, -16F, -3F, 7, 8, 6);
      Shape2.setRotationPoint(0F, 16F, 0F);
      Shape2.setTextureSize(34, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 12, 14);
      Shape3.addBox(3.5F, -14F, -1F, 5, 2, 2);
      Shape3.setRotationPoint(0F, 16F, 0F);
      Shape3.setTextureSize(34, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 12, 18);
      Shape9.addBox(-8.5F, -14F, -1F, 5, 2, 2);
      Shape9.setRotationPoint(0F, 16F, 0F);
      Shape9.setTextureSize(34, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 12, 22);
      Shape4.addBox(-0.5F, -1F, -0.5F, 1, 8, 1);
      Shape4.setRotationPoint(0F, 16F, 0F);
      Shape4.setTextureSize(34, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 16, 22);
      Shape5.addBox(-2F, -8F, -2F, 4, 1, 4);
      Shape5.setRotationPoint(0F, 16F, 0F);
      Shape5.setTextureSize(34, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 26);
      Shape6.addBox(-1F, 2F, -1F, 2, 1, 2);
      Shape6.setRotationPoint(0F, 16F, 0F);
      Shape6.setTextureSize(34, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 26, 0);
      Shape7.addBox(3.5F, -14.5F, -1.5F, 1, 3, 3);
      Shape7.setRotationPoint(0F, 16F, 0F);
      Shape7.setTextureSize(34, 32);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 26, 6);
      Shape8.addBox(-4.5F, -14.5F, -1.5F, 1, 3, 3);
      Shape8.setRotationPoint(0F, 16F, 0F);
      Shape8.setTextureSize(34, 32);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
//    setRotationAngles(f, f1, f2, f3, f4, f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape9.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
  }
  
  public void renderDynamic(float f5, float f6){
	  Shape4.offsetY = f6 - 1/16f;
	  Shape1.render(f5);
	  Shape2.render(f5);
	  Shape3.render(f5);
	  Shape9.render(f5);
	  Shape4.render(f5);
	  Shape5.render(f5);
	  Shape6.render(f5);
	  Shape7.render(f5);
	  Shape8.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
}
