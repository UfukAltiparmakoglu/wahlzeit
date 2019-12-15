package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private static HashMap<Integer, CartesianCoordinate> instances = new HashMap<Integer, CartesianCoordinate>();

	private final double x;
	private final double y;
	private final double z;
	
	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
		CartesianCoordinate tmp = new CartesianCoordinate(x, y, z);
		int hashCode = tmp.hashCode();
		
		if(instances.containsKey(hashCode)) {
			return instances.get(hashCode);
		} else {			
			instances.put(hashCode, tmp);
			return tmp;
		}
	}

	private CartesianCoordinate(double x, double y, double z) {
		
		assertClassInvariants();
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		assertClassInvariants();
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate(){
		assertClassInvariants();
		
		double x_sq = Math.pow(this.x, 2);
		double y_sq = Math.pow(this.y, 2);
		double z_sq = Math.pow(this.z, 2);
		double radius = Math.sqrt(x_sq + y_sq + z_sq);
		double phi = Math.toDegrees(Math.atan(this.y/this.x));
		double theta = Math.toDegrees(Math.acos(this.z/radius));
		
		assertIsValidDouble(phi);
		assertIsValidDouble(theta);
		assertIsValidDouble(radius);
		
		SphericCoordinate sc = SphericCoordinate.getSphericCoordinate(phi, theta, radius);
		
		assertCoordinateIsNotNull(sc);
		
		return sc;
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.x, this.y, this.z);
	}
	
	public double getX() {
		assertClassInvariants();
		return x;
	}

	public double getY() {
		assertClassInvariants();
		return y;
	}

	public double getZ() {
		assertClassInvariants();
		return z;
	}
	
	protected boolean hasValidDoubles() {
		return !Double.isNaN(this.x) && !Double.isNaN(this.y) && !Double.isNaN(this.z);
	}
	
	protected void assertHasValidDoubles() {
		if(!hasValidDoubles()) {
			throw new NumberFormatException("Cartesian coordinate does not have valid doubles!");
		}
	}	

	@Override
	protected void assertClassInvariants() {
		assertCoordinateIsNotNull(this);
		assertHasValidDoubles();
		
		assertIsValidDouble(x);
		assertIsValidDouble(y);
		assertIsValidDouble(z);	
	}
}
