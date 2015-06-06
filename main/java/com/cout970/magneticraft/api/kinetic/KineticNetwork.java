package com.cout970.magneticraft.api.kinetic;

import java.util.LinkedList;

import com.cout970.magneticraft.util.Log;

import net.minecraft.world.World;

public class KineticNetwork {

	public LinkedList<IKineticConductor> componets = new LinkedList<IKineticConductor>();
	public World world;
	
	public KineticNetwork(IKineticConductor firts){
		componets.add(firts);
		world = firts.getParent().getWorldObj();
	}
	
	public void findComponents(){
		KineticPathFinder finder = new KineticPathFinder(world, componets.getFirst());
		while(finder.iterate()){;}
		componets.clear();
		componets.addAll(finder.conds);
	}
	
	public void applyForce(double F){
		setSpeed(Math.max(0, (F/getMass())-getResistance()));
	}

	private double getMass() {
		double mass = 0;
		for(IKineticConductor cond : componets){
			mass += cond.getMass();
		}
		return mass;
	}

	public double getResistance() {
		double resistance = 0;
		for(IKineticConductor cond : componets){
			resistance += cond.getLose();
		}
		return resistance;
	}
	
	public double getSpeed(){
		if(componets.getLast() == null)return 0;
		return componets.getLast().getSpeed();
	}
	
	public void setSpeed(double speed){
		for(IKineticConductor cond : componets){
			cond.setSpeed(speed);
		}
	}
}
