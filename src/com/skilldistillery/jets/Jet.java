package com.skilldistillery.jets;

import java.text.*;
import java.text.DecimalFormat;
import java.util.*;

public abstract class Jet {
	// Fields
	private String type;
	private String model;
	private int range;
	private double speed;
	private long price;

	// Constructors

	public Jet(String type, String model, int range, double speed, long price) {
		super();
		this.type = type;
		this.model = model;
		this.range = range;
		this.speed = speed;
		this.price = price;
	}

	// Fly methods that prints out the jet details and the amount of time the jet
	// can fly until it runs out of fuel (based on speed and range).

	public void fly() {
		DecimalFormat df = new DecimalFormat("#.##");
		double flightFormula = range / speed;
		int hours = (int) ((flightFormula * 60) / 60);
		int minutes = (int) ((flightFormula * 60) % 60);
		System.out.println(this.getModel() + " is flying with " + hours + " hours and " + minutes + " minutes left.");
	}

	// Get the speed in Mach
	public double getSpeedInMach() {
		double speedInMach = (speed / 761.2);
		return Math.round(speedInMach * 100.0) / 100.0;
	}

	// Getters and Setters
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return String.format("%-20s", "Jet Type: " + type) + String.format("%25s", "Model: " + model)
				+ String.format("%15s", "Range: " + range) + "\t\tSpeed: " + speed + "\t\tPrice: " + price
				+ "\t\tMach: " + this.getSpeedInMach();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + range;
		long temp;
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	// hashCode and equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (range != other.range)
			return false;
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
  