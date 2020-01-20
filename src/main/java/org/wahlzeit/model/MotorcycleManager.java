package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.services.DataObject;

public class MotorcycleManager extends DataObject {
	
	private static final long serialVersionUID = 1L;
	
	protected static MotorcycleManager instance = new MotorcycleManager();
	protected static HashMap<Integer, Motorcycle> mm = new HashMap<>();
	protected static HashMap<String, MotorcycleType> mtm = new HashMap<>();
	
	public static MotorcycleManager getInstance() {
	    return instance;
	  }
	
	public Motorcycle createMotorcycle(String typeName) {
		assertIsValidTypeName(typeName);
		
		MotorcycleType mt = getInstance().getMotorcycleType(typeName);
		Motorcycle result = mt.createInstance();
		mm.put(result.hashCode(), result);
		
		return result;
	}
	
	public Motorcycle createMotorcycle(String typeName, String name) {
		
		Motorcycle m = createMotorcycle(typeName);
		
		m.setName(name);
		
		return m;
	}
	
	public Motorcycle createMotorcycle(String typeName, String name, int horsePower) {
		Motorcycle m = createMotorcycle(typeName, name);
		
		m.setHorsePower(horsePower);
		
		return m;
	}
	
	public MotorcycleType createMotorcycleType(String typeName) {
		assertIsValidTypeName(typeName);
		assertTypeDoesNotExist(typeName);
		
		MotorcycleType mt = new MotorcycleType(typeName);
		
		mtm.put(typeName, mt);
		
		return mt;
	}

	public MotorcycleType getMotorcycleType(String typeName) {
		if(!mtm.containsKey(typeName)) {
			this.createMotorcycleType(typeName);
		}
		
		return mtm.get(typeName);
	}

	private void assertIsValidTypeName(String typeName) {
		if(typeName == null || typeName.isEmpty()) {
			throw new IllegalArgumentException("Provided type name is not valid.");
		}		
	}
	
	private void assertTypeDoesNotExist(String typeName) {
		if(mtm.containsKey(typeName)) {
			throw new IllegalArgumentException("Provided type name already exists!");
		}
	}

}
