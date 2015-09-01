// Date: 25/04/2015 16:24:32
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChainSaw extends ModelBase {
    //fields
    ModelRenderer blade;
    ModelRenderer engine;
    ModelRenderer supportup;
    ModelRenderer suportdown;
    ModelRenderer suportdown1;
    ModelRenderer suportdown2;
    ModelRenderer connect;
    ModelRenderer bolt0;
    ModelRenderer bolt1;
    ModelRenderer bolt2;
    ModelRenderer bolt3;

    public ModelChainSaw() {
        textureWidth = 64;
        textureHeight = 32;

        blade = new ModelRenderer(this, 30, 0);
        blade.addBox(-3F, 0F, 4F, 1, 4, 16);
        blade.setRotationPoint(0F, 16F, 0F);
        blade.setTextureSize(64, 32);
        blade.mirror = true;
        setRotation(blade, 0F, 0F, 0F);
        engine = new ModelRenderer(this, 0, 17);
        engine.addBox(-4F, -1F, -5F, 8, 6, 9);
        engine.setRotationPoint(0F, 16F, 0F);
        engine.setTextureSize(64, 32);
        engine.mirror = true;
        setRotation(engine, 0F, 0F, 0F);
        supportup = new ModelRenderer(this, 0, 14);
        supportup.addBox(-3F, -4F, 3F, 7, 2, 1);
        supportup.setRotationPoint(0F, 16F, 0F);
        supportup.setTextureSize(64, 32);
        supportup.mirror = true;
        setRotation(supportup, 0F, 0F, 0F);
        suportdown = new ModelRenderer(this, 34, 20);
        suportdown.addBox(-1.5F, 4F, -11F, 3, 1, 6);
        suportdown.setRotationPoint(0F, 16F, 0F);
        suportdown.setTextureSize(64, 32);
        suportdown.mirror = true;
        setRotation(suportdown, 0F, 0F, 0F);
        suportdown1 = new ModelRenderer(this, 0, 11);
        suportdown1.addBox(-1.5F, 2F, -11F, 3, 2, 1);
        suportdown1.setRotationPoint(0F, 16F, 0F);
        suportdown1.setTextureSize(64, 32);
        suportdown1.mirror = true;
        setRotation(suportdown1, 0F, 0F, 0F);
        suportdown2 = new ModelRenderer(this, 28, 0);
        suportdown2.addBox(-1.5F, 1F, -11F, 3, 1, 6);
        suportdown2.setRotationPoint(0F, 16F, 0F);
        suportdown2.setTextureSize(64, 32);
        suportdown2.mirror = true;
        setRotation(suportdown2, 0F, 0F, 0F);
        connect = new ModelRenderer(this, 26, 10);
        connect.addBox(4F, -5F, 0F, 1, 6, 1);
        connect.setRotationPoint(0F, 16F, 0F);
        connect.setTextureSize(64, 32);
        connect.mirror = true;
        setRotation(connect, -0.8551081F, 0F, 0F);
        bolt0 = new ModelRenderer(this, 0, 9);
        bolt0.addBox(-6F, -3F, 0F, 10, 1, 1);
        bolt0.setRotationPoint(0F, 16F, 0F);
        bolt0.setTextureSize(64, 32);
        bolt0.mirror = true;
        setRotation(bolt0, 0F, 0F, 0F);
        bolt1 = new ModelRenderer(this, 24, 0);
        bolt1.addBox(-6F, -2F, 0F, 1, 7, 1);
        bolt1.setRotationPoint(0F, 16F, 0F);
        bolt1.setTextureSize(64, 32);
        bolt1.mirror = true;
        setRotation(bolt1, 0F, 0F, 0F);
        bolt2 = new ModelRenderer(this, 0, 7);
        bolt2.addBox(-5F, 4F, 0F, 1, 1, 1);
        bolt2.setRotationPoint(0F, 16F, 0F);
        bolt2.setTextureSize(64, 32);
        bolt2.mirror = true;
        setRotation(bolt2, 0F, 0F, 0F);
        bolt3 = new ModelRenderer(this, 0, 5);
        bolt3.addBox(3F, -2F, 0F, 1, 1, 1);
        bolt3.setRotationPoint(0F, 16F, 0F);
        bolt3.setTextureSize(64, 32);
        bolt3.mirror = true;
        setRotation(bolt3, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        //    setRotationAngles(f, f1, f2, f3, f4, f5);
        blade.render(f5);
        engine.render(f5);
        supportup.render(f5);
        suportdown.render(f5);
        suportdown1.render(f5);
        suportdown2.render(f5);
        connect.render(f5);
        bolt0.render(f5);
        bolt1.render(f5);
        bolt2.render(f5);
        bolt3.render(f5);
    }

    public void renderStatic(float f5) {
        blade.render(f5);
        engine.render(f5);
        supportup.render(f5);
        suportdown.render(f5);
        suportdown1.render(f5);
        suportdown2.render(f5);
        connect.render(f5);
        bolt0.render(f5);
        bolt1.render(f5);
        bolt2.render(f5);
        bolt3.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
