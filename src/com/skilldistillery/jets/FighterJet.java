package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {



	public FighterJet(String type, String model, int range, double speed, long price) {
		
		super(type, model, range, speed, price);
		
	}
	
	

	public void fight() {
		System.out.println("DOGFIGHT !!");
	}

}
   