package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {

	@Test
	public void testGetDistance() {
		Coordinate c1 = new Coordinate(0, 0, 0);
		Coordinate c2 = new Coordinate(3, 4, 5);
		Coordinate c3 = new Coordinate(-33, 44, 5600);
		Coordinate c4 = new Coordinate(-33, 44, 5600);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c3);

		assertTrue(loc1.getCoordinate().getDistance(loc1.getCoordinate()) == 0.0);
		assertTrue(loc1.getCoordinate().getDistance(loc2.getCoordinate()) == Math.sqrt(50));
		assertTrue(loc1.getCoordinate().getDistance(loc3.getCoordinate()) == loc3.getCoordinate().getDistance(loc1.getCoordinate()));
		assertTrue(loc1.getCoordinate().getDistance(loc3.getCoordinate()) == Math.sqrt(31363025));
		assertTrue(loc1.getCoordinate().getDistance(loc2.getCoordinate()) == Math.sqrt(50));
	}

	@Test
	public void testIsEqual() {
		Coordinate c1 = new Coordinate(0, 0, 0);
		Coordinate c2 = new Coordinate(3, 4, 5);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c1);

		assertTrue(!loc1.getCoordinate().isEqual(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().isEqual(loc1.getCoordinate()));
	}

	@Test
	public void testEquals() {
		Coordinate c1 = new Coordinate(0, 0, 0);
		Coordinate c2 = new Coordinate(3, 4, 5);
		Location loc1 = new Location(c1);
		Location loc2 = new Location(c2);
		Location loc3 = new Location(c1);

		assertTrue(!loc1.getCoordinate().equals(loc2.getCoordinate()));
		assertTrue(loc1.getCoordinate().equals(loc3.getCoordinate()));
		assertTrue(loc1.getCoordinate().equals(loc1.getCoordinate()));
	}

	@Test
	public void testHashCode() {
		Coordinate c1 = new Coordinate(0, 0, 0);
		Coordinate c2 = new Coordinate(3, 4, 5);
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
		Coordinate c1 = new Coordinate(0.0000000000, 0.0000000000,0.0000000000);
		Coordinate c2 = new Coordinate(0.1000000000, 0.1000000000,0.1000000000);
		Coordinate c3 = new Coordinate(0.0000000001, 0.0000000001,0.0000000001);

		assertTrue(!c1.hasSameDoubleCoordinates(c2));
		assertTrue(c1.hasSameDoubleCoordinates(c3));
	}
}
