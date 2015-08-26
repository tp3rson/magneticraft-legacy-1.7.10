// Date: 02/05/2015 19:54:46
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX


package com.cout970.magneticraft.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelConveyorBelt extends ModelBase {
    //fields
    ModelRenderer Belt;
    ModelRenderer Side1;
    ModelRenderer Side2;
    ModelRenderer corner1;
    ModelRenderer corner2;
    ModelRenderer corner3;
    ModelRenderer corner4;
    ModelRenderer connection1;
    ModelRenderer connection2;

    public ModelConveyorBelt() {
        textureWidth = 64;
        textureHeight = 64;

        Belt = new ModelRenderer(this, 0, 21);
        Belt.addBox(0F, 0F, 0F, 14, 3, 16);
        Belt.setRotationPoint(-7F, 21F, -8F);
        Belt.setTextureSize(64, 64);
        Belt.mirror = true;
        setRotation(Belt, 0F, 0F, 0F);
        Side1 = new ModelRenderer(this, 0, 0);
        Side1.addBox(0F, 0F, 0F, 1, 5, 14);
        Side1.setRotationPoint(-8F, 19F, -7F);
        Side1.setTextureSize(64, 64);
        Side1.mirror = true;
        setRotation(Side1, 0F, 0F, 0F);
        Side2 = new ModelRenderer(this, 0, 0);
        Side2.addBox(0F, 0F, 0F, 1, 5, 14);
        Side2.setRotationPoint(7F, 19F, -7F);
        Side2.setTextureSize(64, 64);
        Side2.mirror = true;
        setRotation(Side2, 0F, 0F, 0F);
        corner1 = new ModelRenderer(this, 0, 0);
        corner1.addBox(0F, 0F, 0F, 1, 5, 1);
        corner1.setRotationPoint(7F, 19F, -8F);
        corner1.setTextureSize(64, 64);
        corner1.mirror = true;
        setRotation(corner1, 0F, 0F, 0F);
        corner2 = new ModelRenderer(this, 0, 0);
        corner2.addBox(0F, 0F, 0F, 1, 5, 1);
        corner2.setRotationPoint(7F, 19F, 7F);
        corner2.setTextureSize(64, 64);
        corner2.mirror = true;
        setRotation(corner2, 0F, 0F, 0F);
        corner3 = new ModelRenderer(this, 0, 0);
        corner3.addBox(0F, 0F, 0F, 1, 5, 1);
        corner3.setRotationPoint(-8F, 19F, 7F);
        corner3.setTextureSize(64, 64);
        corner3.mirror = true;
        setRotation(corner3, 0F, 0F, 0F);
        corner4 = new ModelRenderer(this, 0, 0);
        corner4.addBox(0F, 0F, 0F, 1, 5, 1);
        corner4.setRotationPoint(-8F, 19F, -8F);
        corner4.setTextureSize(64, 64);
        corner4.mirror = true;
        setRotation(corner4, 0F, 0F, 0F);
        connection1 = new ModelRenderer(this, 0, 0);
        connection1.addBox(0F, 0F, 0F, 1, 3, 14);
        connection1.setRotationPoint(-8F, 21F, -7F);
        connection1.setTextureSize(64, 64);
        connection1.mirror = true;
        setRotation(connection1, 0F, 0F, 0F);
        connection2 = new ModelRenderer(this, 0, 0);
        connection2.addBox(0F, 0F, 0F, 1, 3, 14);
        connection2.setRotationPoint(7F, 21F, -7F);
        connection2.setTextureSize(64, 64);
        connection2.mirror = true;
        setRotation(connection2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        Belt.render(f5);
        Side1.render(f5);
        Side2.render(f5);
        corner1.render(f5);
        corner2.render(f5);
        corner3.render(f5);
        corner4.render(f5);
        connection1.render(f5);
        connection2.render(f5);
    }

    public void renderStatic(float f5) {
        Belt.render(f5);
        corner1.render(f5);
        corner2.render(f5);
        corner3.render(f5);
        corner4.render(f5);
    }

    public void renderDynamic(float f5, int sides) {
        if ((sides & 1) > 0) Side1.render(f5);
        else connection1.render(f5);
        if ((sides & 2) > 0) Side2.render(f5);
        else connection2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void renderStatic_block(float f5) {
        corner1.render(f5);
        corner2.render(f5);
        corner3.render(f5);
        corner4.render(f5);
    }
}
