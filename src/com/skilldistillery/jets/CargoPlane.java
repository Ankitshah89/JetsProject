package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String type, String model, int range, double speed, long price) {
		super(type, model, range, speed, price);
	}

	// which just prints out a message about loading cargo
	public void loadCargo() {
		System.out.println("LOADING CARGO !!");

	}

}
