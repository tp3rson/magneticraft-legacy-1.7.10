package com.cout970.magneticraft.client.tilerender;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;

import com.cout970.magneticraft.api.electricity.IElectricConductor;
import com.cout970.magneticraft.api.electricity.wires.ElectricPoleTier1;
import com.cout970.magneticraft.api.electricity.wires.IElectricPole;
import com.cout970.magneticraft.api.electricity.wires.WireConnection;
import com.cout970.magneticraft.api.util.VecDouble;
import com.cout970.magneticraft.client.model.ModelElectricalPoleTier1;
import com.cout970.magneticraft.tileentity.TileElectricPoleTier1;
import com.cout970.magneticraft.util.Log;
import com.cout970.magneticraft.util.RenderUtil;

public class TileRenderElectricPoleTier1 extends TileEntitySpecialRenderer{
	
	private ModelElectricalPoleTier1 model;
	
	public TileRenderElectricPoleTier1(){
		model = new ModelElectricalPoleTier1();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y - 2.5F, (float) z + 0.5F);
		GL11.glColor4f(1, 1, 1, 1);
		GL11.glRotatef(180, 0, 0, 1);

		switch(te.getBlockMetadata()-6){
		case 0:
			GL11.glRotatef(90, 0, 1, 0);
			break;
		case 1:
			GL11.glRotatef(-45, 0, 1, 0);
			break;
		case 2: break;
		case 3:
			GL11.glRotatef(-135, 0, 1, 0);
			break;
		case 4:
			GL11.glRotatef(-90, 0, 1, 0);
			break;
		case 5:
			GL11.glRotatef(-45, 0, 1, 0);
			break;
		case 6: break;
		case 7:
			GL11.glRotatef(45, 0, 1, 0);
			break;
		}

		RenderUtil.bindTexture(ModelTextures.POLE_TIER1);
		model.renderStatic(0.0625f);
		GL11.glPopMatrix();

		ElectricPoleTier1 pole1 = ((TileElectricPoleTier1) te).pole;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y, (float) z);
		GL11.glColor4f(1, 1, 1, 1);
		if(pole1.glList == -1){
			pole1.glList = GL11.glGenLists(1);
			GL11.glNewList(pole1.glList, GL11.GL_COMPILE_AND_EXECUTE);

			int count = pole1.getWireConnector().length;
			for(WireConnection wire : pole1.getConnectedConductors()){
				if(wire.getStart() != pole1)continue;
				IElectricPole pole2 = wire.getEnd();
				if(pole2 == null || pole2.getWireConnector().length != count){
					continue;
				}
				VecDouble off = new VecDouble(-te.xCoord, -te.yCoord, -te.zCoord);
				
				VecDouble dist = new VecDouble(pole2.getParent()).add(off);
				RenderUtil.bindTexture(ModelTextures.ELECTRIC_WIRE_TIER_1);
				for(int i = 0; i < count ;i++){
					VecDouble a = pole1.getWireConnector()[i], b = pole2.getWireConnector()[i];
					b.add(dist);//b relative to a
					VecDouble ab = b.copy().add(a.getOpposite());//(b-a)
					double lenght = ab.mag();//distance between a and b
					VecDouble mid = ab.copy(); //(b-a)
					mid.multiply(0.5).add(a);//(b-a)/2 + a
					double lowPoint = mid.getY() - lenght * 0.05;//height of the middel point less the weight
					double quallity = 15;
					for(int p = 0; p < quallity; p++){
						double adv1 = p/quallity, adv2 = (p+1)/quallity;
						RenderUtil.drawLine(new VecDouble(a.getX()+ab.getX()*adv1, RenderUtil.interpolate(a.getY(), lowPoint, b.getY(), adv1), a.getZ()+ab.getZ()*adv1),
								new VecDouble(a.getX()+ab.getX()*adv2, RenderUtil.interpolate(a.getY(), lowPoint, b.getY(), adv2), a.getZ()+ab.getZ()*adv2),
								0.0625F*0.5F);
					}
				}
			}
			GL11.glEndList();
		}else{
			GL11.glCallList(pole1.glList);
		}
		GL11.glPopMatrix();
	}
}