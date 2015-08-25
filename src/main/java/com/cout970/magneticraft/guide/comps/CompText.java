package com.cout970.magneticraft.guide.comps;

import com.cout970.magneticraft.client.gui.GuiGuideBook;
import com.cout970.magneticraft.guide.BookGuide;
import com.cout970.magneticraft.guide.BookPage;
import com.cout970.magneticraft.guide.Color;
import com.cout970.magneticraft.guide.IPageComp;
import com.google.gson.annotations.Expose;

public class CompText implements IPageComp {

	@Expose
	public int x;
	@Expose
	public int y;
	@Expose
	public String text;
	@Expose
	public Color color;
	@Expose
	public boolean centered;

	public CompText() {}

	public CompText(int x, int y, String text, Color color, boolean centered) {
		this.x = x;
		this.y = y;
		this.text = text;
		this.color = color;
		this.centered = centered;
	}

	@Override
	public void render(int mx, int my, GuiGuideBook gui, BookPage page, BookGuide guide) {
		if (centered) {
			gui.drawCenteredString(gui.getFontRenderer(), text, gui.xStart + x, gui.yStart + y,
					color != null ? color.toInteger() : 0);
		} else {
			gui.drawString(gui.getFontRenderer(), text, gui.xStart + x, gui.yStart + y,
					color != null ? color.toInteger() : 0);
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
		return "simple_text";
	}

	@Override
	public void renderTop(int mx, int my, GuiGuideBook gui, BookPage page, BookGuide guide) {
	}
}
