package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for the CartesianCoordinate class.
 */
public class CartesianCoordinateTest {

	@Test
	public void testGetDistance() {
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate c2 = new CartesianCoordinate(3, 4, 5);
		CartesianCoordinate c3 = new CartesianCoordinate(-33, 44, 5600);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c3);

		assertTrue(loc1.getCoordinate().asCartesianCoordinate()
				.getDistance(loc1.getCoordinate().asCartesianCoordinate()) == 0.0);
		assertTrue(loc1.getCoordinate().asCartesianCoordinate()
				.getDistance(loc2.getCoordinate().asCartesianCoordinate()) == Math.sqrt(50));
		assertTrue(loc1.getCoordinate().asCartesianCoordinate()
				.getDistance(loc3.getCoordinate().asCartesianCoordinate())
				== loc3.getCoordinate().asCartesianCoordinate().getDistance(loc1.getCoordinate().asCartesianCoordinate()));
		assertTrue(loc1.getCoordinate().asCartesianCoordinate()
				.getDistance(loc3.getCoordinate().asCartesianCoordinate()) == Math.sqrt(31363025));
		assertTrue(loc1.getCoordinate().asCartesianCoordinate()
				.getDistance(loc2.getCoordinate().asCartesianCoordinate()) == Math.sqrt(50));
	}

	@Test
	public void testIsEqual() {
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate c2 = new CartesianCoordinate(3, 4, 5);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c1);

		assertTrue(!loc1.getCoordinate().isEqual(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc1.getCoordinate()));
	}

	@Test
	public void testEquals() {
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate c2 = new CartesianCoordinate(3, 4, 5);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c1);

		assertTrue(!loc1.getCoordinate().equals(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().equals(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().equals(loc1.getCoordinate()));
	}

	@Test
	public void testHashCode() {
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate c2 = new CartesianCoordinate(3, 4, 5);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c1);
		Location loc4 = loc1;

		assertTrue(loc1.getCoordinate().hashCode() != loc2.getCoordinate().hashCode());
		assertTrue(loc1.getCoordinate().hashCode() == loc3.getCoordinate().hashCode());
		assertTrue(loc1.getCoordinate().hashCode() == loc4.getCoordinate().hashCode());
		assertTrue(loc2.getCoordinate().hashCode() != loc4.getCoordinate().hashCode());
	}

	@Test
	public void testHasSameDoubleCoordinates(){
		CartesianCoordinate c1 = new CartesianCoordinate(0.0000000000, 0.0000000000,0.0000000000);
		CartesianCoordinate c2 = new CartesianCoordinate(0.1000000000, 0.1000000000,0.1000000000);
		CartesianCoordinate c3 = new CartesianCoordinate(0.0000000001, 0.0000000001,0.0000000001);

		assertTrue(!c1.hasSameDoubleCoordinates(c2));
		assertTrue(c1.hasSameDoubleCoordinates(c3));
	}
	
	@Test
	public void testAsCartesianCoordinate(){
		SphericCoordinate sc = new SphericCoordinate(1.0, 1.0, 1.0);

		assertTrue(sc.asCartesianCoordinate() instanceof CartesianCoordinate);
	}
	
	@Test
	public void testGetCartesianDistance(){
		CartesianCoordinate c1 = new CartesianCoordinate(0, 0, 0);
		CartesianCoordinate c2 = new CartesianCoordinate(3, 4, 5);
		CartesianCoordinate c3 = new CartesianCoordinate(-33, 44, 5600);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c3);

		assertTrue(loc1.getCoordinate().getCartesianDistance(loc1.getCoordinate()) == 0.0);
		assertTrue(loc1.getCoordinate().getCartesianDistance(loc2.getCoordinate()) == Math.sqrt(50));
		assertTrue(loc1.getCoordinate().getCartesianDistance(loc3.getCoordinate()) == loc3.getCoordinate().getCartesianDistance(loc1.getCoordinate()));
		assertTrue(loc1.getCoordinate().getCartesianDistance(loc3.getCoordinate()) == Math.sqrt(31363025));
		assertTrue(loc1.getCoordinate().getCartesianDistance(loc2.getCoordinate()) == Math.sqrt(50));
	}
	
	@Test
	public void testAsSphericCoordinate(){
		CartesianCoordinate cc = new CartesianCoordinate(1.0, 1.0, 1.0);

		assertTrue(cc.asSphericCoordinate() instanceof SphericCoordinate);
	}
	
	@Test
	public void testGetCentralAngle(){
		CartesianCoordinate cc1 = new CartesianCoordinate(0.0, 1.0, 0.0);
		CartesianCoordinate cc2 = new CartesianCoordinate(1.0, 0.0, 0.0);

		double angle = Math.round(cc1.getCentralAngle(cc2));
		
		assertTrue(angle == 45.0);
	}
	
}
