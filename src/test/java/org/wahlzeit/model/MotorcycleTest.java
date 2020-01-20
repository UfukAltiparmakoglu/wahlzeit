package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MotorcycleTest {

	@Test
	public void testConstructorWithType() {
		MotorcycleType mt = new MotorcycleType("type1");
		Motorcycle mp = new Motorcycle(mt);
	
	    assertTrue(mp.getName() == null);
	    assertTrue(mp.getHorsePower() == -1);
	    assertTrue(mp.getClass() == Motorcycle.class);
	}

	@Test
	public void testConstructorWithTypeAndName() {
		MotorcycleType mt = new MotorcycleType("type2");
		Motorcycle mp = new Motorcycle(mt, "Honda");
		
	
	    assertTrue(mp.getName() == "Honda");
	    assertTrue(mp.getHorsePower() == -1);
	    assertTrue(mp.getClass() == Motorcycle.class);
	}

	@Test
	public void testConstructorFull() {
		MotorcycleType mt = new MotorcycleType("type3");
		Motorcycle mp = new Motorcycle(mt, "Honda", 198);
	
	    assertTrue(mp.getName() == "Honda");
	    assertTrue(mp.getHorsePower() == 198);
	    assertTrue(mp.getClass() == Motorcycle.class);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFaultyConstructor() {
		
		MotorcycleType mt = new MotorcycleType("type4");
		Motorcycle mp = new Motorcycle(mt, "Honda", -5);
	}
  
	@Test(expected = IllegalArgumentException.class)
	public void testAssertIsValidInteger() {
		MotorcycleType mt = new MotorcycleType("type5");
		Motorcycle mp = new Motorcycle(mt, "Honda", 198);
		
		mp.setHorsePower(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void assertIsValidName() {
		MotorcycleType mt = new MotorcycleType("type6");
		Motorcycle mp = new Motorcycle(mt, "Honda", 198);
		
		mp.setName("   ");
	}
}
