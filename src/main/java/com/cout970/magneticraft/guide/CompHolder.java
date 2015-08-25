package com.cout970.magneticraft.guide;

import java.util.ArrayList;

import com.cout970.magneticraft.guide.comps.CompCraftingRecipe;
import com.cout970.magneticraft.guide.comps.CompItemRender;
import com.cout970.magneticraft.guide.comps.CompLargeText;
import com.cout970.magneticraft.guide.comps.CompPageLink;
import com.cout970.magneticraft.guide.comps.CompText;
import com.google.gson.annotations.Expose;
import com.google.gson.internal.LinkedTreeMap;

public class CompHolder {

	@Expose
	public String id;
	@Expose
	public Object component;
	public IPageComp comp;

	public CompHolder() {}

	public CompHolder(IPageComp comp) {
		this.comp = comp;
		id = comp.getID();
		component = comp;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IPageComp getComponent() {
		if (comp == null) {
			if (component instanceof LinkedTreeMap) {
				LinkedTreeMap<String, Object> map = (LinkedTreeMap) component;

				if ("simple_text".equals(id)) {
					CompText temp = new CompText();
					temp.x = toInt(map, "x");
					temp.y = toInt(map, "y");
					temp.text = (String) map.get("text");
					temp.color = new Color((LinkedTreeMap<String, Object>) map.get("color"));
					temp.centered = (Boolean) map.get("centered");

					comp = temp;
				} else if ("item_render".equals(id)) {
					CompItemRender temp = new CompItemRender();
					temp.x = toInt(map, "x");
					temp.y = toInt(map, "y");
					temp.item = new Stack((LinkedTreeMap<String, Object>) map.get("item"));

					comp = temp;
				} else if ("crafting_recipe".equals(id)) {
					CompCraftingRecipe temp = new CompCraftingRecipe();
					temp.x = toInt(map, "x");
					temp.y = toInt(map, "y");
					temp.load((ArrayList) map.get("recipe"));

					comp = temp;
				} else if ("large_text".equals(id)) {
					CompLargeText temp = new CompLargeText();
					temp.x = toInt(map, "x");
					temp.y = toInt(map, "y");
					temp.text = (String[]) ((ArrayList) map.get("text")).toArray(new String[0]);
					temp.color = new Color((LinkedTreeMap<String, Object>) map.get("color"));
					temp.centered = (Boolean) map.get("centered");

					comp = temp;
				} else if ("page_link".equals(id)) {
					CompPageLink temp = new CompPageLink();
					temp.left = (Boolean) map.get("left");
					temp.page = (String) map.get("page");

					comp = temp;
				}
			}
		}
		return comp;
	}

	private int toInt(LinkedTreeMap<String, Object> map, String string) {
		Double d = (Double) map.get(string);
		return d.intValue();
	}
}