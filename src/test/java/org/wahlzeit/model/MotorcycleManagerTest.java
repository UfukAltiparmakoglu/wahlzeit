package org.wahlzeit.model;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MotorcycleManagerTest {
	@Test
	public void testGetInstance() {
		MotorcycleManager mm = MotorcycleManager.getInstance();

		assertNotNull(mm);
		assertTrue(mm.getClass() == MotorcycleManager.class);
	}	
	
	@Test
	public void testCreateMotorcycle() {
		
		MotorcycleManager mm = MotorcycleManager.getInstance();
		
		mm.createMotorcycle("type11");
		
		assertTrue(mm.createMotorcycle("type11").getClass() == Motorcycle.class);
		
		assertTrue(MotorcycleManager.getInstance().getMotorcycleType("type11").getClass() == MotorcycleType.class);
	}
	
	@Test
	public void testCreateMotorcycleType() {
		MotorcycleManager mm = MotorcycleManager.getInstance();
		
		assertTrue(mm.createMotorcycleType("type22").getClass() == MotorcycleType.class);	
	}	
}
