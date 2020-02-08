package com.skilldistillery.jets;

public class otherType extends Jet implements otherCarrier {
	public otherType(String type, String model, int range, double speed, long price) {
		super(type, model, range, speed, price);

	}

	public void pilotMessage() {
		System.out.println("WELCOME ABOARD !!");
	}

}
