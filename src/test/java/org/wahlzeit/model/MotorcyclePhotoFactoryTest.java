package org.wahlzeit.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MotorcyclePhotoFactoryTest {

	@Test
	public void testCreatePhotoEmpty(){
		MotorcyclePhotoFactory mpf = MotorcyclePhotoFactory.getInstance();
    MotorcyclePhoto mp = mpf.createPhoto();

    assertTrue(mp.getName() == null);
    assertTrue(mp.getHorsePower() == -1);
    assertTrue(mp.getClass() == MotorcyclePhoto.class);
	}

  @Test
	public void testCreatePhotoWithId() {
		MotorcyclePhotoFactory mpf = MotorcyclePhotoFactory.getInstance();
    PhotoId id = new PhotoId(123456);
    MotorcyclePhoto mp = mpf.createPhoto(id);

    assertTrue(mp.getId() == id);
    assertTrue(mp.getName() == null);
    assertTrue(mp.getHorsePower() == -1);
    assertTrue(mp.getClass() == MotorcyclePhoto.class);
	}

  @Test
	public void testCreatePhotoFull() {
		MotorcyclePhotoFactory mpf = MotorcyclePhotoFactory.getInstance();
    PhotoId id = new PhotoId(123456);
    String name = "Kawasaki";
    int hp = 198;
    MotorcyclePhoto mp = mpf.createPhoto(id, name, hp);

    assertTrue(mp.getId() == id);
    assertTrue(mp.getName() == name);
    assertTrue(mp.getHorsePower() == hp);
    assertTrue(mp.getClass() == MotorcyclePhoto.class);
	}

	@Test
	public void testGetInstance(){
		MotorcyclePhotoFactory mpf = MotorcyclePhotoFactory.getInstance();
		MotorcyclePhotoFactory mpf2 = MotorcyclePhotoFactory.getInstance();
		assertEquals(mpf, mpf2);
		assertTrue(mpf.getClass() == MotorcyclePhotoFactory.class);
		assertTrue(mpf2.getClass() == MotorcyclePhotoFactory.class);
	}
}
