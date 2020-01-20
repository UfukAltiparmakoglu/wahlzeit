package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MotorcyclePhotoTest {

	@Test
	public void testConstructorEmpty() {
	    MotorcyclePhoto mp = new MotorcyclePhoto();
	    
	    assertTrue(mp.getClass() == MotorcyclePhoto.class);
	    assertTrue(mp.getMotorcycle() != null);
	}

	@Test
	public void testConstructorWithId() {
		PhotoId id = new PhotoId(123456);
		MotorcyclePhoto mp = new MotorcyclePhoto(id);
		
		assertTrue(mp.getId() == id);
		assertTrue(mp.getClass() == MotorcyclePhoto.class);
		assertTrue(mp.getMotorcycle() != null);
	}

	@Test
	public void testConstructorFull() {
		PhotoId id = new PhotoId(123456);
		String name = "Kawasaki";
		int hp = 198;
		
		MotorcyclePhoto mp = new MotorcyclePhoto(id, name);
		
		assertTrue(mp.getId() == id);
		assertTrue(mp.getClass() == MotorcyclePhoto.class);
		assertTrue(mp.getMotorcycle() != null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFaultyConstructor() {
		PhotoId id = new PhotoId(123456);
		MotorcyclePhoto mp = new MotorcyclePhoto(id, null, 5);
	}
}
