package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MotorcyclePhotoManagerTest {
	@Test
	public void testGetInstance() {
		MotorcyclePhotoManager mpm = MotorcyclePhotoManager.getInstance();

		assertNotNull(mpm);
		assertTrue(mpm.getClass() == MotorcyclePhotoManager.class);
	}
}
