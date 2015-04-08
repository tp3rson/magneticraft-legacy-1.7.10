package com.cout970.magneticraft.client.tilerender;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.cout970.magneticraft.api.util.MgDirection;
import com.cout970.magneticraft.client.model.ModelKineticGenerator;
import com.cout970.magneticraft.tileentity.TileKineticGenerator;
import com.cout970.magneticraft.util.RenderUtil;

public class TileRenderKineticGenerator extends TileEntitySpecialRenderer{
	
	private ModelKineticGenerator model;
	
	public TileRenderKineticGenerator(){
		model = new ModelKineticGenerator();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float frames) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0, 0, 1);
		TileKineticGenerator tile = (TileKineticGenerator) t;
		
		if(tile.getOrientation() == MgDirection.NORTH){
			GL11.glRotatef(180, 0, 1, 0);
		}else if(tile.getOrientation() == MgDirection.WEST){
			GL11.glRotatef(90, 0, 1, 0);
		}else if(tile.getOrientation() == MgDirection.EAST){
			GL11.glRotatef(-90, 0, 1, 0);
		}else if(tile.getOrientation() == MgDirection.DOWN){
			GL11.glRotatef(-90, 1, 0, 0);
			GL11.glTranslatef(0, -1, 1);
		}else if(tile.getOrientation() == MgDirection.UP){
			GL11.glRotatef(90, 1, 0, 0);
			GL11.glTranslatef(0, -1, -1);
		}
		
		RenderUtil.bindTexture(ModelTextures.KINETIC_GEN);
		model.renderStatic(0.0625f);
		if(tile.isActive())tile.rotation += tile.getDelta()*0.5f;
		if(tile.rotation > 1000) tile.rotation -= 1000;
		if(tile.rotation > 10000)tile.rotation = 0;
		model.renderDynamic(0.0625f,-tile.rotation);
		GL11.glPopMatrix();
	}
}
