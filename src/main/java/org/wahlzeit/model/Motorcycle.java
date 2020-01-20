package org.wahlzeit.model;

import org.wahlzeit.services.DataObject;

public class Motorcycle extends DataObject {
	
	private static final long serialVersionUID = 1L;
	
	private Location loc;
	private int horsePower = -1;
	private String name;
	
	protected MotorcycleType motorcycleType = null;
	
	public Motorcycle(MotorcycleType mt) {
		this.motorcycleType = mt;
	}
	
	public Motorcycle(MotorcycleType mt, String name) {
		this.motorcycleType = mt;
		setName(name);
	}
	
	public Motorcycle(MotorcycleType mt, String name, int horsePower) {
		this.motorcycleType = mt;
		setName(name);
		setHorsePower(horsePower);
	}
	
	public void setLocation(Location loc) {
		assertIsValidLocation(loc);
		this.loc = loc;		
	}
	
	public Location getLocation() {
		return this.loc;		
	}

	public void setHorsePower(int horsePower) {
		assertIsValidInteger(horsePower);
		this.horsePower = horsePower;		
	}
	
	public int getHorsePower() {
		return this.horsePower;		
	}
	
	public void setName(String name) {
		assertIsValidName(name);
		this.name = name;		
	}
	
	public String getName() {
		return this.name;		
	}

	public MotorcycleType getType() {
		return this.motorcycleType;
	}
	
	private void assertIsValidLocation(Location loc) {
		if(loc == null) {
			throw new IllegalArgumentException("Provided location can not be null!");
		}		
	}
	
	private void assertIsValidInteger(int horsePower) {
		if(horsePower <= 0 || horsePower > 1000) {
			throw new IllegalArgumentException("Provided horsePower is not between 1 and 1000!");
		}
	}

	private void assertIsValidName(String name) {
		if(name == null || name.isEmpty() || name.matches(".*\\s+.*")) {
			throw new IllegalArgumentException("Provided name can not be empty!");
		}		
	}
}
