package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MotorcyclePhotoTest {

	@Test
	public void testConstructorEmpty() {
	    MotorcyclePhoto mp = new MotorcyclePhoto();
	
	    assertTrue(mp.getName() == null);
	    assertTrue(mp.getHorsePower() == -1);
	    assertTrue(mp.getClass() == MotorcyclePhoto.class);
	}

	@Test
	public void testConstructorWithId() {
		PhotoId id = new PhotoId(123456);
		MotorcyclePhoto mp = new MotorcyclePhoto(id);
		
		assertTrue(mp.getId() == id);
		assertTrue(mp.getName() == null);
		assertTrue(mp.getHorsePower() == -1);
		assertTrue(mp.getClass() == MotorcyclePhoto.class);
	}

	@Test
	public void testConstructorFull() {
		PhotoId id = new PhotoId(123456);
		String name = "Kawasaki";
		int hp = 198;
		MotorcyclePhoto mp = new MotorcyclePhoto(id, name, hp);
		
		assertTrue(mp.getId() == id);
		assertTrue(mp.getName() == name);
		assertTrue(mp.getHorsePower() == hp);
		assertTrue(mp.getClass() == MotorcyclePhoto.class);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFaultyConstructor() {
		PhotoId id = new PhotoId(123456);
		MotorcyclePhoto mp = new MotorcyclePhoto(id, "   ", -5);
	}
  
	@Test(expected = IllegalArgumentException.class)
	public void testAssertIsValidInteger() {
		MotorcyclePhoto mp = new MotorcyclePhoto();
		mp.setHorsePower(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void assertIsValidName() {
		MotorcyclePhoto mp = new MotorcyclePhoto();
		mp.setName("   ");
	}
}
