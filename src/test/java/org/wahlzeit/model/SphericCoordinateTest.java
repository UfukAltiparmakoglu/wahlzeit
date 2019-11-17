package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test cases for the CartesianCoordinate class.
 */
public class SphericCoordinateTest {

	@Test
	public void testGetDistance() {
		SphericCoordinate s1 = new SphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = new SphericCoordinate(0, 0, 1);
		SphericCoordinate s3 = new SphericCoordinate(0, 0, 2);		
		
		assertTrue(s1.getDistance(s1) == 0.0);
		assertTrue(s1.getDistance(s2) == 1.0);
		assertTrue(s1.getDistance(s3) == 2.0);
	}

	@Test
	public void testIsEqual() {
		SphericCoordinate s1 = new SphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = new SphericCoordinate(3, 4, 5);
		Location loc1 = new Location(s1);
		Location loc2 = new Location(s2);
		Location loc3 = new Location(s1);

		assertTrue(!loc1.getCoordinate().isEqual(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc1.getCoordinate()));
	}

	@Test
	public void testEquals() {
		SphericCoordinate s1 = new SphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = new SphericCoordinate(3, 4, 5);
		Location loc1 = new Location(s1);
		Location loc2 = new Location(s2);
		Location loc3 = new Location(s1);

		assertTrue(!loc1.getCoordinate().isEqual(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc1.getCoordinate()));
	}

	@Test
	public void testHashCode() {
		SphericCoordinate s1 = new SphericCoordinate(0, 0, 0);
		SphericCoordinate s2 = new SphericCoordinate(3, 4, 5);
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
		SphericCoordinate s1 = new SphericCoordinate(0.0000000000, 0.0000000000,0.0000000000);
		SphericCoordinate s2 = new SphericCoordinate(0.1000000000, 0.1000000000,0.1000000000);
		SphericCoordinate c3 = new SphericCoordinate(0.0000000001, 0.0000000001,0.0000000001);

		assertTrue(!s1.hasSameDoubleCoordinates(s2));
		assertTrue(s1.hasSameDoubleCoordinates(c3));
	}
	
	
	@Test
	public void testAsCartesianCoordinate(){
		SphericCoordinate sc = new SphericCoordinate(1.0, 1.0, 1.0);

		assertTrue(sc.asCartesianCoordinate() instanceof CartesianCoordinate);
	}
	
	@Test
	public void testGetCartesianDistance(){
		SphericCoordinate s1 = new SphericCoordinate(Math.PI/2, Math.PI/2, 1);
		SphericCoordinate s2 = new SphericCoordinate(Math.PI, Math.PI, 1);
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
		CartesianCoordinate cc = new CartesianCoordinate(1.0, 1.0, 1.0);

		assertTrue(cc.asSphericCoordinate() instanceof SphericCoordinate);
	}
	
	@Test
	public void testGetCentralAngle(){
		SphericCoordinate sc1 = new SphericCoordinate(0.0, 0.0, 1.0);
		SphericCoordinate sc2 = new SphericCoordinate(Math.PI/2, Math.PI/2, 1.0);

		assertTrue((int) sc1.getCentralAngle(sc2) == 90);
	}
}
