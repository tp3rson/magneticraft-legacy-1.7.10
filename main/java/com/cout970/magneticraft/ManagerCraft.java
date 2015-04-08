package com.cout970.magneticraft;

import static com.cout970.magneticraft.ManagerBlocks.airlock;
import static com.cout970.magneticraft.ManagerBlocks.basic_gen;
import static com.cout970.magneticraft.ManagerBlocks.battery;
import static com.cout970.magneticraft.ManagerBlocks.biomass_burner;
import static com.cout970.magneticraft.ManagerBlocks.boiler;
import static com.cout970.magneticraft.ManagerBlocks.breaker;
import static com.cout970.magneticraft.ManagerBlocks.chasis;
import static com.cout970.magneticraft.ManagerBlocks.conveyor_l;
import static com.cout970.magneticraft.ManagerBlocks.cooler;
import static com.cout970.magneticraft.ManagerBlocks.crusher;
import static com.cout970.magneticraft.ManagerBlocks.firebox;
import static com.cout970.magneticraft.ManagerBlocks.fluidhopper;
import static com.cout970.magneticraft.ManagerBlocks.furnace;
import static com.cout970.magneticraft.ManagerBlocks.geothermal;
import static com.cout970.magneticraft.ManagerBlocks.grinder;
import static com.cout970.magneticraft.ManagerBlocks.heat_cable;
import static com.cout970.magneticraft.ManagerBlocks.heat_resist;
import static com.cout970.magneticraft.ManagerBlocks.heater;
import static com.cout970.magneticraft.ManagerBlocks.housing;
import static com.cout970.magneticraft.ManagerBlocks.infinite_water;
import static com.cout970.magneticraft.ManagerBlocks.inserter;
import static com.cout970.magneticraft.ManagerBlocks.kinetic;
import static com.cout970.magneticraft.ManagerBlocks.miner;
import static com.cout970.magneticraft.ManagerBlocks.mirror;
import static com.cout970.magneticraft.ManagerBlocks.multi_energy;
import static com.cout970.magneticraft.ManagerBlocks.multi_io;
import static com.cout970.magneticraft.ManagerBlocks.permagnet;
import static com.cout970.magneticraft.ManagerBlocks.polimerizer;
import static com.cout970.magneticraft.ManagerBlocks.pumpJack;
import static com.cout970.magneticraft.ManagerBlocks.refinery;
import static com.cout970.magneticraft.ManagerBlocks.refinery_gap;
import static com.cout970.magneticraft.ManagerBlocks.refinery_tank;
import static com.cout970.magneticraft.ManagerBlocks.solar_tower_core;
import static com.cout970.magneticraft.ManagerBlocks.solarpanel;
import static com.cout970.magneticraft.ManagerBlocks.steamengine;
import static com.cout970.magneticraft.ManagerBlocks.stirling;
import static com.cout970.magneticraft.ManagerBlocks.tank_mg;
import static com.cout970.magneticraft.ManagerBlocks.tesla_coil;
import static com.cout970.magneticraft.ManagerBlocks.thermopile;
import static com.cout970.magneticraft.ManagerBlocks.transformer_lm;
import static com.cout970.magneticraft.ManagerBlocks.transformer_mh;
import static com.cout970.magneticraft.ManagerBlocks.windturbine;
import static com.cout970.magneticraft.ManagerItems.battery_item;
import static com.cout970.magneticraft.ManagerItems.cablehigh;
import static com.cout970.magneticraft.ManagerItems.cablelow;
import static com.cout970.magneticraft.ManagerItems.cablemedium;
import static com.cout970.magneticraft.ManagerItems.copper_coil;
import static com.cout970.magneticraft.ManagerItems.drill;
import static com.cout970.magneticraft.ManagerItems.heatCoilCopper;
import static com.cout970.magneticraft.ManagerItems.heatCoilIron;
import static com.cout970.magneticraft.ManagerItems.heatCoilTungsten;
import static com.cout970.magneticraft.ManagerItems.ingotCarbide;
import static com.cout970.magneticraft.ManagerItems.map;
import static com.cout970.magneticraft.ManagerItems.motor;
import static com.cout970.magneticraft.ManagerItems.oil_prospector;
import static com.cout970.magneticraft.ManagerItems.partcopperpipe;
import static com.cout970.magneticraft.ManagerItems.photoelectricDust;
import static com.cout970.magneticraft.ManagerItems.string_fabric;
import static com.cout970.magneticraft.ManagerItems.therm;
import static com.cout970.magneticraft.ManagerItems.turbine_0;
import static com.cout970.magneticraft.ManagerItems.turbine_1;
import static com.cout970.magneticraft.ManagerItems.turbine_2;
import static com.cout970.magneticraft.ManagerItems.turbine_wing;
import static com.cout970.magneticraft.ManagerItems.volt;
import static com.cout970.magneticraft.ManagerItems.wire_copper;
import static com.cout970.magneticraft.ManagerItems.wrench;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ManagerCraft {

	public static void init(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(housing), new Object[]{"ici","cvc","ici",'i',"ingotIron",'c',"ingotCopper"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(battery), new Object[]{"wbw","bcb","wbw",'w',"ingotIron",'c',"ingotCopper",'b',battery_item}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(furnace), new Object[]{"iri","ihi","ibi",'i',"ingotIron",'r',"dustRedstone",'b',battery_item,'h',housing}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(transformer_lm), new Object[]{"vcv","lcm","iii",'l',cablelow,'m',cablemedium,'c',copper_coil,'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(transformer_mh), new Object[]{"vcv","mch","iii",'h',cablehigh,'m',cablemedium,'c',copper_coil,'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(kinetic), new Object[]{"ici","ctc","ici",'c',copper_coil,'i',"ingotIron",'t',"ingotCarbide"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(basic_gen), new Object[]{"cbc","gmg","chc",'c',"ingotCopper",'m',housing,'b',battery_item,'h',heat_cable,'g',"blockGlass"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(heat_cable,8), new Object[]{"bbb","bsb","bbb",'b',Items.brick,'s',"dustSalt"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(firebox), new Object[]{"bbb","fhf","bbb",'b',Items.brick,'f',Blocks.furnace,'h',heat_cable}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(boiler), new Object[]{"ccc","chc","ccc",'h',housing,'c',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cooler), new Object[]{"viv","ihi","viv",'h',heat_cable,'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(crusher), new Object[]{"fif","mhm","fbf",'h',chasis,'i',"ingotIron",'f',Items.flint,'m',motor,'b',battery_item}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(chasis,9), new Object[]{"iii","ihi","iii",'h',"ingotCarbide",'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(multi_io), new Object[]{"hc",'h',chasis,'c',Blocks.chest}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(conveyor_l,6), new Object[]{"ggg","iii",'g',"itemPlastic",'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(pumpJack), new Object[]{"iii","viv","mid",'i',"ingotIron",'m',motor,'d',drill}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(mirror), new Object[]{"viv","ihi","viv",'h',"ingotTungsten",'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(windturbine), new Object[]{"iii","bmt","iii",'i',"ingotIron",'t',"ingotCarbide",'m',motor,'b',battery_item}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(permagnet,2), new Object[]{"iti","tvt","iti",'i',"ingotIron",'t',"ingotTungsten"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(fluidhopper), new Object[]{"igi","igi","viv",'i',"ingotIron",'g',"blockGlass"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(heat_resist), new Object[]{"iii","iti","iii",'i',Items.clay_ball,'t',heat_cable}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(breaker), new Object[]{"iii","iti","idi",'i',"ingotIron",'t',housing,'d',drill}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(steamengine), new Object[]{"tgt","cjc","iii",'i',"ingotIron",'t',"ingotCarbide",'c',"ingotCopper",'g',"blockGlass",'j',motor}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(geothermal), new Object[]{"ttt","tht","tdt",'t',"ingotCarbide",'h',heat_cable,'d',drill}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(thermopile), new Object[]{"ici","ivi","isi",'i',"ingotIron",'c',heatCoilCopper,'s',heatCoilIron}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(multi_energy), new Object[]{"mc",'m',chasis,'c',cablelow}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(inserter), new Object[]{"vvi","viv","imi",'m',motor,'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(grinder), new Object[]{"cmc","ihi","ibi",'m',motor,'i',"ingotIron",'c',"ingotCarbide",'h',chasis,'b',battery_item}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(miner), new Object[]{"chc","mmm","ddd",'m',motor,'d',drill,'c',cablemedium,'h',housing}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(tesla_coil), new Object[]{"cic","cic","bib",'i',"ingotIron",'b',battery_item,'c',copper_coil}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(airlock), new Object[]{"gmg","ghg","ggg",'g',"blockGlass",'h',housing,'m',motor}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(biomass_burner), new Object[]{"bbb","fhf","bbb",'b',"ingotCarbide",'f',Blocks.furnace,'h',heat_cable}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(stirling), new Object[]{"ibi","ihi","ici",'i',"ingotIron",'h',housing,'c',heat_cable,'b',battery_item}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(infinite_water), new Object[]{"gbg","bhb","gbg",'g',"blockGlass",'h',housing,'b',Items.bucket}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(refinery), new Object[]{"ctc","tht","ctc",'c',"ingotCopper",'h',chasis,'t',"ingotTungsten"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(refinery_gap,9), new Object[]{"vcv","chc","vcv",'c',"ingotCopper",'h',chasis}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(refinery_tank,3), new Object[]{"rrr","vtv",'r',refinery_gap,'t',tank_mg}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(tank_mg,2), new Object[]{"cgc","gvg","cgc",'c',"ingotCopper",'g',"blockGlass"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(heater), new Object[]{"iti","tht","iti",'t',"ingotTungsten",'h',housing,'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(solar_tower_core), new Object[]{"ttt","tht","ttt",'h',heat_cable,'t',"ingotTungsten"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(solarpanel), new Object[]{"qqq","iii","ccc",'q',"dustQuartz",'i',photoelectricDust,'c',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(polimerizer), new Object[]{"cgc","ghg","cgc",'c',"ingotCarbide",'h',chasis,'g',Items.glass_bottle}));

		//items
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(battery_item), new Object[]{"scs","sis","scs",'i',"ingotIron",'c',"ingotCopper",'s',"dustSulfur"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(copper_coil), new Object[]{"vcv","cbc","vcv",'c',"ingotCopper",'b',Blocks.iron_bars}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(drill), new Object[]{"i","i","d",'d',"gemDiamond",'i',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(motor), new Object[]{"cjc","iii","cjc",'c',"ingotCopper",'i',"ingotIron",'j',copper_coil}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(heatCoilCopper), new Object[]{"cc","cc",'c',"ingotCopper"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(heatCoilIron), new Object[]{"cc","cc",'c',"ingotIron"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(heatCoilTungsten), new Object[]{"cc","cc",'c',"ingotTungsten"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(photoelectricDust,9), new Object[]{"ccc","cdc","ccc",'c',"dustQuartz",'d',"dustDiamond"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ingotCarbide,4), new Object[]{"vcv","ctc","vcv",'c',Items.coal,'t',"ingotTungsten"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(volt), new Object[]{"cgc","cgc","lmh",'c',"itemPlastic",'g',"paneGlass",'l',cablelow,'m',cablemedium,'h',cablehigh}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(therm), new Object[]{"cgc","cgc","crc",'c',"itemPlastic",'g',"paneGlass",'r',"dustRedstone"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(map), new Object[]{"vpv","ptp","vpv",'p',Items.paper,'t',new ItemStack(Items.dye,1,0)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(wrench), new Object[]{"ii","ti","ti",'i',"ingotIron",'t',new ItemStack(Items.dye,1,1)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(string_fabric), new Object[]{"iii","iii","iii",'i',Items.string}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(turbine_wing), new Object[]{"sf","sf","sv",'s',Items.stick,'f',string_fabric}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(turbine_0), new Object[]{"vwv","wpw","vwv",'w',turbine_wing,'p',"plankWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(turbine_1), new Object[]{"vwv","wpw","vwv",'w',turbine_wing,'p',turbine_0}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(turbine_2), new Object[]{"vwv","wpw","vwv",'w',turbine_wing,'p',turbine_1}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(oil_prospector), new Object[]{"b","i","d",'b',battery_item,'i',"ingotIron",'d',drill}));
		
		//multipart
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cablelow,2), new Object[]{"w","c","w",'c',"ingotCopper",'w',Blocks.wool}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cablelow,2), new Object[]{"w","c",'c',"ingotCopper",'w',"itemPlastic"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(wire_copper,4), new Object[]{"vwv","wcw",'c',"ingotCopper",'w',Blocks.wool}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(wire_copper,4), new Object[]{"wcw",'c',"ingotCopper",'w',"itemPlastic"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cablemedium), new Object[]{"w","c","w",'c',cablelow,'w',Blocks.wool}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cablehigh), new Object[]{"w","c","w",'c',cablemedium,'w',Blocks.wool}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cablemedium), new Object[]{"w","c",'c',cablelow,'w',"itemPlastic"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(cablehigh), new Object[]{"w","c",'c',cablemedium,'w',"itemPlastic"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(partcopperpipe,8), new Object[]{"cgc",'c',"ingotCopper",'g',"blockGlass"}));
	}
}
