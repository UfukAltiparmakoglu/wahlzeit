package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MotorcycleTypeTest {

	@Test
	public void testConstructor() {
		MotorcycleType mt = new MotorcycleType("type1");
		Motorcycle mp = new Motorcycle(mt);
		
	    assertTrue(mp.getClass() == Motorcycle.class);
	    assertTrue(mt.getClass() == MotorcycleType.class);
	}

	@Test
	public void testSetSuperType() {
		MotorcycleType mt = new MotorcycleType("type1");
		MotorcycleType someSuperType = new MotorcycleType("superType1");
		
		assertTrue(mt.getSuperType() == null);
		
		mt.setSuperType(someSuperType);
		
		assertTrue(mt.getSuperType() != null);
	}

	@Test
	public void testIsSubType() {
		MotorcycleType mt = new MotorcycleType("type1");
		MotorcycleType someSubType = new MotorcycleType("subType1");
		
		assertTrue(!mt.getSubTypeIterator().hasNext());
		
		mt.addSubtype(someSubType);
		
		assertTrue(mt.getSubTypeIterator().next() == someSubType);
	}
}
