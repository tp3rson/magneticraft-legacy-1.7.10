// Date: 06/01/2015 4:49:48
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelKineticGenerator extends ModelBase {
    //fields
    ModelRenderer eje;
    ModelRenderer coil1;
    ModelRenderer coil2;
    ModelRenderer coil3;
    ModelRenderer coil4;
    ModelRenderer support1;
    ModelRenderer junction;
    ModelRenderer subcoil1;
    ModelRenderer subcoil2;
    ModelRenderer subcoil3;
    ModelRenderer subcoil4;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;

    public ModelKineticGenerator() {
        textureWidth = 64;
        textureHeight = 64;

        eje = new ModelRenderer(this, 0, 48);
        eje.addBox(-1F, -1F, -7F, 2, 2, 14);
        eje.setRotationPoint(0F, 16F, 0F);
        eje.setTextureSize(64, 64);
        eje.mirror = true;
        setRotation(eje, 0F, 0F, 0F);
        coil1 = new ModelRenderer(this, 0, 31);
        coil1.addBox(-2F, 2F, -6F, 4, 4, 12);
        coil1.setRotationPoint(0F, 16F, 0F);
        coil1.setTextureSize(64, 64);
        coil1.mirror = true;
        setRotation(coil1, 0F, 0F, 0F);
        coil2 = new ModelRenderer(this, 0, 31);
        coil2.addBox(-2F, -6F, -6F, 4, 4, 12);
        coil2.setRotationPoint(0F, 16F, 0F);
        coil2.setTextureSize(64, 64);
        coil2.mirror = true;
        setRotation(coil2, 0F, 0F, 0F);
        coil3 = new ModelRenderer(this, 0, 31);
        coil3.addBox(2F, -2F, -6F, 4, 4, 12);
        coil3.setRotationPoint(0F, 16F, 0F);
        coil3.setTextureSize(64, 64);
        coil3.mirror = true;
        setRotation(coil3, 0F, 0F, 0F);
        coil4 = new ModelRenderer(this, 0, 31);
        coil4.addBox(-6F, -2F, -6F, 4, 4, 12);
        coil4.setRotationPoint(0F, 16F, 0F);
        coil4.setTextureSize(64, 64);
        coil4.mirror = true;
        setRotation(coil4, 0F, 0F, 0F);
        support1 = new ModelRenderer(this, 32, 35);
        support1.addBox(-7F, -7F, -8F, 14, 14, 1);
        support1.setRotationPoint(0F, 16F, 0F);
        support1.setTextureSize(64, 64);
        support1.mirror = true;
        setRotation(support1, 0F, 0F, 0F);
        junction = new ModelRenderer(this, 32, 27);
        junction.addBox(-2F, -2F, -2F, 4, 4, 4);
        junction.setRotationPoint(0F, 16F, 0F);
        junction.setTextureSize(64, 64);
        junction.mirror = true;
        setRotation(junction, 0F, 0F, 0F);
        subcoil1 = new ModelRenderer(this, 32, 50);
        subcoil1.addBox(2F, -4F, -6F, 2, 2, 12);
        subcoil1.setRotationPoint(0F, 16F, 0F);
        subcoil1.setTextureSize(64, 64);
        subcoil1.mirror = true;
        setRotation(subcoil1, 0F, 0F, 0F);
        subcoil2 = new ModelRenderer(this, 32, 50);
        subcoil2.addBox(-4F, -4F, -6F, 2, 2, 12);
        subcoil2.setRotationPoint(0F, 16F, 0F);
        subcoil2.setTextureSize(64, 64);
        subcoil2.mirror = true;
        setRotation(subcoil2, 0F, 0F, 0F);
        subcoil3 = new ModelRenderer(this, 32, 50);
        subcoil3.addBox(2F, 2F, -6F, 2, 2, 12);
        subcoil3.setRotationPoint(0F, 16F, 0F);
        subcoil3.setTextureSize(64, 64);
        subcoil3.mirror = true;
        setRotation(subcoil3, 0F, 0F, 0F);
        subcoil4 = new ModelRenderer(this, 32, 50);
        subcoil4.addBox(-4F, 2F, -6F, 2, 2, 12);
        subcoil4.setRotationPoint(0F, 16F, 0F);
        subcoil4.setTextureSize(64, 64);
        subcoil4.mirror = true;
        setRotation(subcoil4, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 0, 28);
        Shape1.addBox(-8F, -6F, 5F, 1, 12, 3);
        Shape1.setRotationPoint(0F, 16F, 0F);
        Shape1.setTextureSize(64, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 28);
        Shape2.addBox(7F, -6F, 5F, 1, 12, 3);
        Shape2.setRotationPoint(0F, 16F, 0F);
        Shape2.setTextureSize(64, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 28);
        Shape3.addBox(7F, -6F, -8F, 1, 12, 3);
        Shape3.setRotationPoint(0F, 16F, 0F);
        Shape3.setTextureSize(64, 64);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 0, 28);
        Shape4.addBox(-8F, -6F, -8F, 1, 12, 3);
        Shape4.setRotationPoint(0F, 16F, 0F);
        Shape4.setTextureSize(64, 64);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 0, 24);
        Shape5.addBox(-6F, -8F, 5F, 12, 1, 3);
        Shape5.setRotationPoint(0F, 16F, 0F);
        Shape5.setTextureSize(64, 64);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 0, 24);
        Shape6.addBox(-6F, -8F, -8F, 12, 1, 3);
        Shape6.setRotationPoint(0F, 16F, 0F);
        Shape6.setTextureSize(64, 64);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 0, 0);
        Shape7.addBox(6F, -8F, -8F, 2, 2, 16);
        Shape7.setRotationPoint(0F, 16F, 0F);
        Shape7.setTextureSize(64, 64);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 0, 0);
        Shape8.addBox(-8F, -8F, -8F, 2, 2, 16);
        Shape8.setRotationPoint(0F, 16F, 0F);
        Shape8.setTextureSize(64, 64);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 0, 0);
        Shape9.addBox(-8F, 6F, -8F, 2, 2, 16);
        Shape9.setRotationPoint(0F, 16F, 0F);
        Shape9.setTextureSize(64, 64);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 0, 0);
        Shape10.addBox(6F, 6F, -8F, 2, 2, 16);
        Shape10.setRotationPoint(0F, 16F, 0F);
        Shape10.setTextureSize(64, 64);
        Shape10.mirror = true;
        setRotation(Shape10, 0F, 0F, 0F);
        Shape11 = new ModelRenderer(this, 0, 24);
        Shape11.addBox(-6F, 7F, 5F, 12, 1, 3);
        Shape11.setRotationPoint(0F, 16F, 0F);
        Shape11.setTextureSize(64, 64);
        Shape11.mirror = true;
        setRotation(Shape11, 0F, 0F, 0F);
        Shape12 = new ModelRenderer(this, 0, 24);
        Shape12.addBox(-6F, 7F, -8F, 12, 1, 3);
        Shape12.setRotationPoint(0F, 16F, 0F);
        Shape12.setTextureSize(64, 64);
        Shape12.mirror = true;
        setRotation(Shape12, 0F, 0F, 0F);
        Shape13 = new ModelRenderer(this, 34, 0);
        Shape13.addBox(-7F, -7F, 7F, 14, 14, 1);
        Shape13.setRotationPoint(0F, 16F, 0F);
        Shape13.setTextureSize(64, 64);
        Shape13.mirror = true;
        setRotation(Shape13, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        eje.render(f5);
        coil1.render(f5);
        coil2.render(f5);
        coil3.render(f5);
        coil4.render(f5);
        support1.render(f5);
        junction.render(f5);
        subcoil1.render(f5);
        subcoil2.render(f5);
        subcoil3.render(f5);
        subcoil4.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape6.render(f5);
        Shape7.render(f5);
        Shape8.render(f5);
        Shape9.render(f5);
        Shape10.render(f5);
        Shape11.render(f5);
        Shape12.render(f5);
        Shape13.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void renderStatic(float f5) {

        support1.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape6.render(f5);
        Shape7.render(f5);
        Shape8.render(f5);
        Shape9.render(f5);
        Shape10.render(f5);
        Shape11.render(f5);
        Shape12.render(f5);
        Shape13.render(f5);
    }

    public void renderDynamic(float f5, float g) {
        GL11.glTranslatef(0, 1, 0);
        GL11.glPushMatrix();
        GL11.glRotatef(g, 0, 0, 1);
        GL11.glTranslatef(0, -1, 0);
        eje.render(f5);
        coil1.render(f5);
        coil2.render(f5);
        coil3.render(f5);
        coil4.render(f5);
        junction.render(f5);
        subcoil1.render(f5);
        subcoil2.render(f5);
        subcoil3.render(f5);
        subcoil4.render(f5);
        GL11.glPopMatrix();
    }

}
