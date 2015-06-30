package com.cout970.magneticraft.api.acces;

import net.minecraftforge.fluids.FluidStack;

import com.cout970.magneticraft.api.util.MgUtils;

/**
 * 
 * @author Cout970
 *
 */
public class RecipeRefinery {
	
	private FluidStack input;
	private FluidStack out0;
	private FluidStack out1;
	private FluidStack out2;
	
	
	public RecipeRefinery(FluidStack in,FluidStack o0,FluidStack o1,FluidStack o2){
		input = in;
		out0 = o0;
		out1 = o1;
		out2 = o2;
	}


	public FluidStack getInput() {
		return input;
	}


	public FluidStack getOut0() {
		return out0;
	}


	public FluidStack getOut1() {
		return out1;
	}


	public FluidStack getOut2() {
		return out2;
	}
	
	public String toString(){
		return "Refinery Recipe, Input: "+input.getLocalizedName()+", Amount:"+input.amount+", Outputs 1: "+out0.getLocalizedName()+", Amount:"+input.amount+", 2: "+out1.getLocalizedName()+", Amount:"+input.amount+", 3: "+out2.getLocalizedName()+", Amount:"+input.amount;
	}
	
	public boolean matches(FluidStack f){
		if(MgUtils.areEcuals(f, input))return true;
		return false;
	}
	
	public static RecipeRefinery getRecipe(FluidStack i){
		for(RecipeRefinery r : MgRecipeRegister.refinery){
			if(r.matches(i))return r;
		}
		return null;
	}
}
