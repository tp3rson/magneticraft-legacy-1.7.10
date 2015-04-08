// Date: 09/08/2014 17:43:30
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRefinery extends ModelBase
{
  //fields
    ModelRenderer base1;
    ModelRenderer middle1;
    ModelRenderer base2;
    ModelRenderer middle2;
  
  public ModelRefinery()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      base1 = new ModelRenderer(this, 0, 54);
      base1.addBox(-24F, 0F, -24F, 48, 1, 48);
      base1.setRotationPoint(0F, 7F, 0F);
      base1.setTextureSize(256, 128);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      middle1 = new ModelRenderer(this, 0, 0);
      middle1.addBox(-23F, 0F, -23F, 46, 7, 46);
      middle1.setRotationPoint(0F, 0F, 0F);
      middle1.setTextureSize(256, 128);
      middle1.mirror = true;
      setRotation(middle1, 0F, 0F, 0F);
      base2 = new ModelRenderer(this, 0, 54);
      base2.addBox(-24F, 0F, -24F, 48, 1, 48);
      base2.setRotationPoint(0F, -1F, 0F);
      base2.setTextureSize(256, 128);
      base2.mirror = true;
      setRotation(base2, 0F, 0F, 0F);
      middle2 = new ModelRenderer(this, 0, 0);
      middle2.addBox(-23F, 0F, -23F, 46, 7, 46);
      middle2.setRotationPoint(0F, -8F, 0F);
      middle2.setTextureSize(256, 128);
      middle2.mirror = true;
      setRotation(middle2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base1.render(f5);
    middle1.render(f5);
    base2.render(f5);
    middle2.render(f5);
  }

  public void render(float f5){
	  base1.render(f5);
	  middle1.render(f5);
	  base2.render(f5);
	  middle2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
  }

}
