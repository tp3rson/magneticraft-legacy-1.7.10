package com.cout970.magneticraft.guide.comps;

import com.cout970.magneticraft.client.gui.GuiGuideBook;
import com.cout970.magneticraft.guide.BookGuide;
import com.cout970.magneticraft.guide.BookPage;
import com.cout970.magneticraft.guide.IPageComp;
import com.cout970.magneticraft.guide.Stack;
import com.cout970.magneticraft.util.RenderUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.internal.LinkedTreeMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.ArrayList;
import java.util.List;

public class CompCraftingRecipe implements IPageComp {

    @Expose
    public int x;
    @Expose
    public int y;
    @Expose
    public Stack[] recipe;

    public CompCraftingRecipe(ItemStack[] item, int x, int y) {
        this.x = x;
        this.y = y;
        recipe = new Stack[10];
        for (int i = 0; i < item.length && i < recipe.length; i++) {
            if (item[i] != null) {
                recipe[i] = new Stack(item[i]);
            }
        }
    }

    public CompCraftingRecipe() {

    }

    @Override
    public void render(int mx, int my, GuiGuideBook gui, BookPage page, BookGuide guide) {
        if (recipe != null && recipe.length == 10) {
            RenderUtil.bindTexture(GuiGuideBook.arrows);
            RenderUtil.drawTexturedModalRectScaled(gui.xStart + x + 58, gui.yStart + y + 24, 0, 0, 8, 6, 16, 16);
            GL11.glPushMatrix();
            GL11.glColor3f(1, 1, 1);
            GL11.glTranslatef(gui.xStart, gui.yStart, 0);
            RenderHelper.enableGUIStandardItemLighting();
            GL11.glDisable(GL11.GL_LIGHTING);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glEnable(GL11.GL_COLOR_MATERIAL);
            GL11.glEnable(GL11.GL_LIGHTING);
            if (recipe[0] != null && recipe[0].getStack() != null) {
                RenderItem.getInstance().renderItemAndEffectIntoGUI(gui.getFontRenderer(),
                        Minecraft.getMinecraft().renderEngine, recipe[0].getStack(), x + 72, y + 18);
                RenderItem.getInstance().renderItemOverlayIntoGUI(gui.getFontRenderer(),
                        Minecraft.getMinecraft().renderEngine, recipe[0].getStack(), x + 72, y + 18);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int index = 1 + j + i * 3;
                    if (recipe[index] != null && recipe[index].getStack() != null) {
                        RenderItem.getInstance().renderItemAndEffectIntoGUI(gui.getFontRenderer(),
                                Minecraft.getMinecraft().renderEngine, recipe[index].getStack(), x + i * 18,
                                y + j * 18);
                        RenderItem.getInstance().renderItemOverlayIntoGUI(gui.getFontRenderer(),
                                Minecraft.getMinecraft().renderEngine, recipe[index].getStack(), x + i * 18,
                                y + j * 18);
                    }
                }
            }
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glColor4f(1, 1, 1, 1);
            GL11.glPopMatrix();
        }
    }

    @Override
    public void onClick(int mx, int my, int buttom, GuiGuideBook gui, BookPage page, BookGuide guide) {
    }

    @Override
    public boolean onKey(int n, char key, GuiGuideBook gui, BookPage page, BookGuide guide) {
        return false;
    }

    @Override
    public String getID() {
        return "crafting_recipe";
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public void load(ArrayList arrayList) {
        recipe = new Stack[10];
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null) {
                recipe[i] = new Stack((LinkedTreeMap<String, Object>) arrayList.get(i));
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void renderTop(int mx, int my, GuiGuideBook gui, BookPage page, BookGuide guide) {
        if (recipe != null && recipe.length == 10) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int index = 1 + j + i * 3;
                    if (gui.isIn(mx, my, gui.xStart + x + i * 18, gui.yStart + y + j * 18, 16, 16)
                            && recipe[index] != null) {
                        List data = recipe[index].getStack().getTooltip(gui.mc.thePlayer, false);
                        gui.drawHoveringText2(data, mx - gui.xStart, my - gui.yStart);
                        RenderHelper.enableGUIStandardItemLighting();
                    }
                }
            }
            if (gui.isIn(mx, my, gui.xStart + x + 72, gui.yStart + y + 18, 16, 16) && recipe[0] != null) {
                List data = recipe[0].getStack().getTooltip(gui.mc.thePlayer, false);
                gui.drawHoveringText2(data, mx - gui.xStart, my - gui.yStart);
                RenderHelper.enableGUIStandardItemLighting();
            }
        }
    }

}
