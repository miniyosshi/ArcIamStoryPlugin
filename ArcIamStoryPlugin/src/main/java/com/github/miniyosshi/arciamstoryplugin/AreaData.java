package com.github.miniyosshi.arciamstoryplugin;

import org.bukkit.Location;


public class AreaData{
	private String name;
	private Location cornerA;
	private Location cornerB;
	
	
	AreaData(String name, Location cornerA, Location cornerB){
		this.name = name;
		this.cornerA = cornerA;
		this.cornerB = cornerB;
	}
	
	
	String getName() {
		return name;
	}
	
	
	/*
	static AreaData getAreaData(Location loc) {
		for (AreaData a : CSVReader.areadata) {
			if (a) {
				return a;
			}
		}
		
		return CSVReader.areadata.get(0);
	}
	*/
	
	
	Location getcornerA() {
		return cornerA;
	}
	
	Location getcornerB() {
		return cornerB;
	}
	
	public void setLocation(int i, Location loc) {
		if(i == 0) {
			this.cornerA = loc;
		}
		else {
			this.cornerB = loc;
		}
	}
	
}

