package com.cout970.magneticraft.client.tilerender;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.cout970.magneticraft.api.radiation.IRadiactiveItem;
import com.cout970.magneticraft.client.model.ModelReactorRod;
import com.cout970.magneticraft.client.model.ModelReactorVessel;
import com.cout970.magneticraft.tileentity.TileReactorVessel;
import com.cout970.magneticraft.util.RenderUtil;

public class TileRenderReactorVessel extends TileEntitySpecialRenderer{
	
	private ModelReactorVessel model;
	private ModelReactorRod rod;
	
	public TileRenderReactorVessel(){
		model = new ModelReactorVessel();
		rod = new ModelReactorRod();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,
			double z, float scale) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glColor4d(1, 1, 1, 1);
		GL11.glRotatef(180, 0, 0, 1);
		RenderUtil.bindTexture(ModelTextures.REACTOR_VESSEL);
		model.renderStatic(0.0625f);
		TileReactorVessel v = (TileReactorVessel) te;
		for(int i = 0;i<4;i++){
			if(v.getStackInSlot(i) != null && v.getStackInSlot(i).getItem() instanceof IRadiactiveItem){
				RenderUtil.bindTexture(((IRadiactiveItem) v.getStackInSlot(i).getItem()).getResourceLocation());
				renderRod(i);
			}
		}
		GL11.glPopMatrix();
	}

	private void renderRod(int i) {
		GL11.glPushMatrix();
		float dist = 3/16f;
		if(i == 0)GL11.glTranslatef(dist,0,-dist);
		if(i == 1)GL11.glTranslatef(dist,0,dist);
		if(i == 2)GL11.glTranslatef(-dist,0,-dist);
		if(i == 3)GL11.glTranslatef(-dist,0,dist);
		rod.renderStatic(0.0625f);
		GL11.glPopMatrix();
	}
}