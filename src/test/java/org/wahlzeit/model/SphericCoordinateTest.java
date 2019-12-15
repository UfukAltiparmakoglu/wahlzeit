package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for the CartesianCoordinate class.
 */
public class SphericCoordinateTest {

	@Test
	public void testGetDistance() {
		SphericCoordinate s1 = SphericCoordinate.getSphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = SphericCoordinate.getSphericCoordinate(0, 0, 1);
		SphericCoordinate s3 = SphericCoordinate.getSphericCoordinate(0, 0, 2);		
		
		assertTrue(s1.getDistance(s1) == 0.0);
		assertTrue(s1.getDistance(s2) == 1.0);
		assertTrue(s1.getDistance(s3) == 2.0);
	}

	@Test
	public void testIsEqual() {
		SphericCoordinate s1 = SphericCoordinate.getSphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = SphericCoordinate.getSphericCoordinate(3, 4, 5);
		Location loc1 = new Location(s1);
		Location loc2 = new Location(s2);
		Location loc3 = new Location(s1);

		assertTrue(!loc1.getCoordinate().isEqual(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc1.getCoordinate()));
	}

	@Test
	public void testEquals() {
		SphericCoordinate s1 = SphericCoordinate.getSphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = SphericCoordinate.getSphericCoordinate(3, 4, 5);
		Location loc1 = new Location(s1);
		Location loc2 = new Location(s2);
		Location loc3 = new Location(s1);

		assertTrue(!loc1.getCoordinate().isEqual(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc1.getCoordinate()));
	}

	@Test
	public void testHashCode() {
		SphericCoordinate s1 = SphericCoordinate.getSphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = SphericCoordinate.getSphericCoordinate(3, 4, 5);
		Location loc1 = new Location(s1);
		Location loc2 = new Location(s2);
		Location loc3 = new Location(s1);
		Location loc4 = loc1;

		assertTrue(loc1.getCoordinate().hashCode() != loc2.getCoordinate().hashCode());
		assertTrue(loc1.getCoordinate().hashCode() == loc3.getCoordinate().hashCode());
		assertTrue(loc1.getCoordinate().hashCode() == loc4.getCoordinate().hashCode());
		assertTrue(loc2.getCoordinate().hashCode() != loc4.getCoordinate().hashCode());
	}
	
	@Test
	public void testHasSameDoubleCoordinates(){
		SphericCoordinate s1 = SphericCoordinate.getSphericCoordinate(0.0000000000, 0.0000000000,0.0000000000);
		SphericCoordinate s2 = SphericCoordinate.getSphericCoordinate(0.1000000000, 0.1000000000,0.1000000000);
		SphericCoordinate c3 = SphericCoordinate.getSphericCoordinate(0.0000000001, 0.0000000001,0.0000000001);

		assertTrue(!s1.hasSameDoubleCoordinates(s2));
		assertTrue(s1.hasSameDoubleCoordinates(c3));
	}
	
	
	@Test
	public void testAsCartesianCoordinate(){
		SphericCoordinate sc = SphericCoordinate.getSphericCoordinate(1.0, 1.0, 1.0);

		assertTrue(sc.asCartesianCoordinate() instanceof CartesianCoordinate);
	}
	
	@Test
	public void testGetCartesianDistance(){
		SphericCoordinate s1 = SphericCoordinate.getSphericCoordinate(Math.PI/2, Math.PI/2, 1);
		SphericCoordinate s2 = SphericCoordinate.getSphericCoordinate(Math.PI, Math.PI, 1);
		Location loc1 = new Location(s1);
		Location loc2 = new Location(s2);
		Location loc3 = new Location(s1);

		assertTrue(loc1.getCoordinate().getCartesianDistance(loc1.getCoordinate()) == 0.0);
		assertTrue(loc1.getCoordinate().getCartesianDistance(loc3.getCoordinate()) == 0.0);
		assertTrue(Math.round(loc1.getCoordinate().getCartesianDistance(loc2.getCoordinate())) == 57.0);
		assertTrue(Math.round(loc2.getCoordinate().getCartesianDistance(loc1.getCoordinate())) == 57.0);
		assertTrue(loc1.getCoordinate().getCartesianDistance(loc2.getCoordinate()) 
				== loc2.getCoordinate().getCartesianDistance(loc1.getCoordinate()));
	}
	
	@Test
	public void testAsSphericCoordinate(){
		CartesianCoordinate cc = CartesianCoordinate.getCartesianCoordinate(1.0, 1.0, 1.0);

		assertTrue(cc.asSphericCoordinate() instanceof SphericCoordinate);
	}
	
	@Test
	public void testGetCentralAngle(){
		SphericCoordinate sc1 = SphericCoordinate.getSphericCoordinate(0.0, 0.0, 1.0);
		SphericCoordinate sc2 = SphericCoordinate.getSphericCoordinate(Math.PI/2, Math.PI/2, 1.0);

		assertTrue((int) sc1.getCentralAngle(sc2) == 90);
	}
	
	@Test
	public void testGetSphericCoordinate(){		
		SphericCoordinate sc1 = SphericCoordinate.getSphericCoordinate(Math.PI/2, Math.PI/2, 1.0);
		SphericCoordinate sc2 = SphericCoordinate.getSphericCoordinate(Math.PI/2, Math.PI/2, 1.0);
		SphericCoordinate sc3 = SphericCoordinate.getSphericCoordinate(Math.PI/2, Math.PI/2, 2.0);		
		
		assertTrue(sc1.isEqual(sc2));
		assertTrue(!sc1.isEqual(sc3));
		assertTrue(!sc2.isEqual(sc3));
	}
	
	@Test(expected = NullPointerException.class)
	public void testAssertCoordinateIsNotNull() {
		
		SphericCoordinate sc = SphericCoordinate.getSphericCoordinate(1.0, 1.0, 1.0);
		sc.getDistance(null);
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAssertIsValidRadius() {
		
		SphericCoordinate sc = SphericCoordinate.getSphericCoordinate(1.0, 1.0, -1.0);
	}
}
