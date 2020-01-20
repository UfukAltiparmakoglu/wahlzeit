package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class MotorcycleType extends DataObject {
	
	private static final long serialVersionUID = 1L;
	
	private String typeName;	
	protected MotorcycleType superType = null;
	protected Set<MotorcycleType> subTypes = new HashSet<MotorcycleType>();
	
	public MotorcycleType(String typeName) {
		setTypeName(typeName);
	}

	public MotorcycleType getSuperType() {
		return superType;
	}
	
	public void setSuperType(MotorcycleType mt) {
		this.superType = mt;
	}
	
	public boolean isSubtype(MotorcycleType mt) {
		
		for (Iterator<MotorcycleType> iter = getSubTypeIterator(); iter.hasNext();) {
			MotorcycleType tmp = iter.next();
			if(tmp.equals(mt)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Iterator<MotorcycleType> getSubTypeIterator(){
		return subTypes.iterator();
	}
	
	public void addSubtype(MotorcycleType mt) {
		assert(mt != null) : "Tried to set null sub-type!";
		mt.setSuperType(this);
		subTypes.add(mt);
	}
	
	public Motorcycle createInstance() {
		return new Motorcycle(this, "default");
	}
	
	public boolean hasInstance(Motorcycle motorcycle) {
		assert (motorcycle != null) : "Asked about null object!";
		
		if (motorcycle.getType() == this) {
			return true;
		}
		
		for (MotorcycleType type : subTypes) {
			if (type.hasInstance(motorcycle)) {
				return true;
			}
		}
		return false;
	}
	
	private void setTypeName(String typeName) {
		assertIsValidTypeName(typeName);
		this.typeName = typeName;
	}
	
	private String getTypeName() {
		return this.typeName;
	}
	
	private void assertIsValidTypeName(String typeName) {
		if(typeName == null || typeName.isEmpty()) {
			throw new IllegalArgumentException("Provided type name is not valid!");
		}
	}

}
