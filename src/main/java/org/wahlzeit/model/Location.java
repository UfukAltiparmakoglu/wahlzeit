package org.wahlzeit.model;

public class Location {
	
	private Coordinate coordinate;
	
	public Location (Coordinate coord) {
		this.setCoordinate(coord);	
	}
	
	public Coordinate getCoordinate() {
		return this.coordinate;
	}
	
	public void setCoordinate(Coordinate coord) {
		this.coordinate = coord;
	}	
}
