package com.chandu.java.collections.HashMap;

public class Vehicle implements Comparable<Vehicle> {

	String name;
	int maxspeed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMaxspeed() {
		return maxspeed;
	}

	public void setMaxspeed(int maxspeed) {
		this.maxspeed = maxspeed;
	}

	public Vehicle(String name, int maxspeed) {
		super();
		this.name = name;
		this.maxspeed = maxspeed;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", maxspeed=" + maxspeed + "]";
	}

	@Override
	public int compareTo(Vehicle o) {
		return this.getName().compareTo(o.getName());
	}

}
