package com.cout970.magneticraft.guide;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GuideBookIO {

	public static final String FILE_PATH = "/assets/magneticraft/guide/main.json";
	public static BookGuide book;

	public static void loadBook() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		InputStream stream = GuideBookIO.class.getResourceAsStream(FILE_PATH);
		InputStreamReader reader = new InputStreamReader(stream);
		book = gson.fromJson(reader, BookGuide.class);
		if (book == null) {
			book = new BookGuide();
		}
	}

	public static void saveBook() {
//		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		book = null;
		if (book == null) {
			book = new BookGuide();
			//TOREMOVE some teests with the guide book
//			BookPage page = new BookPage();
//			// page.addComponent(new CompItemRender(new ItemStack(Blocks.stone,
//			// 10), 15, 23));
//			page.addComponent(new CompCraftingRecipe(new ItemStack[] { new ItemStack(Blocks.diamond_block),
//					new ItemStack(Items.diamond), new ItemStack(Items.diamond), new ItemStack(Items.diamond),
//					new ItemStack(Items.diamond), new ItemStack(Items.diamond), new ItemStack(Items.diamond),
//					new ItemStack(Items.diamond), new ItemStack(Items.diamond), new ItemStack(Items.diamond) }, 188,
//					23));
//			page.addComponent(new CompCraftingRecipe(new ItemStack[] { new ItemStack(Blocks.gold_block),
//					new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot),
//					new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot),
//					new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot), new ItemStack(Items.gold_ingot) },
//					45, 95));
//			page.addComponent(new CompLargeText(26, 22, new String[] { "Line1", "Line2", "Line3", "Line4", "Line5" },
//					new Color(1, 1, 1), false));
//			page.addComponent(new CompPageLink("idex", false));
//			BookPage page2 = new BookPage();
//			page2.addComponent(new CompLargeText(26, 22, new String[] { "Line1", "Line2", "Line3", "Line4", "Line5" },
//					new Color(1, 1, 1), false));
//			page2.addComponent(new CompPageLink("main", true));
//			book.addPage("main", page);
//			book.addPage("idex", page2);
		}
//		String json = gson.toJson(book);
//		Log.debug(json);
	}

	public static BookGuide getBook() {
		if (book == null) {
			loadBook();
		}
		return book;
	}
}