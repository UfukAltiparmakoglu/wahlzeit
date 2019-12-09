package org.wahlzeit.model;

public class Location {
	
	private Coordinate coordinate;
	
	public Location (Coordinate coord) throws IllegalArgumentException{
		this.setCoordinate(coord);	
	}
	
	public Coordinate getCoordinate() throws NullPointerException{
		assertClassInvariants();
		return this.coordinate;
	}	

	public void setCoordinate(Coordinate coord) throws IllegalArgumentException{
		assertIsValidCoordinate(coord);
		this.coordinate = coord;
	}
	
	private void assertClassInvariants() {
		if(this.coordinate == null) {
			throw new NullPointerException("Coordinate is null!");
		}	
	}

	private void assertIsValidCoordinate(Coordinate coord) {
		if(coord == null) {
			throw new IllegalArgumentException("Provided coordinate was null!");
		}		
	}	
}
