package org.wahlzeit.model;

import org.junit.Test;

public class LocationTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testFaultyConstructor() {
		Location loc = new Location(null);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAssertIsValidCoordinate() {
		Coordinate c = new CartesianCoordinate(1.0, 1.0, 1.0);
		Location loc = new Location(c);
		
		loc.setCoordinate(null);
	}
}
