package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {
	
	private static HashMap<Integer, SphericCoordinate> instances = new HashMap<Integer, SphericCoordinate>();

	private final double phi;
	private final double theta;
	private final double radius;
	
	public static SphericCoordinate getSphericCoordinate(double x, double y, double z) {
		SphericCoordinate tmp = new SphericCoordinate(x, y, z);
		int hashCode = tmp.hashCode();
		
		if(instances.containsKey(hashCode)) {
			return instances.get(hashCode);
		} else {			
			instances.put(hashCode, tmp);
			return tmp;
		}
	}

	private SphericCoordinate(double phi, double theta, double radius) {
		assertIsValidDouble(phi);
		assertIsValidDouble(theta);
		assertIsValidDouble(radius);		
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		
		assertClassInvariants();
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate(){
		assertClassInvariants();
		
		double phi_ = this.phi;
		double theta_ = this.theta;
		
		double x = Math.toDegrees(this.radius * Math.sin(theta_) * Math.cos(phi_));
		double y = Math.toDegrees(this.radius * Math.sin(theta_) * Math.sin(phi_));
		double z = this.radius * Math.cos(theta_);
		
		assertIsValidDouble(x);
		assertIsValidDouble(y);
		assertIsValidDouble(z);
		
		CartesianCoordinate cc = CartesianCoordinate.getCartesianCoordinate(x,y,z);
		
		assertCoordinateIsNotNull(cc);

		return cc;
	}	

	@Override
	public int hashCode(){
		return Objects.hash(this.phi, this.theta, this.radius);
	}	

	public double getPhi() {
		assertClassInvariants();
		return phi;
	}

	public double getTheta() {
		assertClassInvariants();
		return theta;
	}

	public double getRadius() {
		assertClassInvariants();
		return radius;
	}
	
	protected boolean hasValidDoubles() {
		return !Double.isNaN(this.phi) && !Double.isNaN(this.theta) && !Double.isNaN(this.radius);
	}
	
	protected void assertHasValidDoubles() {
		if(!hasValidDoubles()) {
			throw new NumberFormatException("Spheric coordinate does not have valid doubles!");
		}
	}	
	
	protected void assertIsValidPhi(double phi) {
		assertIsValidDouble(phi);
		if(phi < -Math.PI/2 && phi > Math.PI/2) {
			throw new IllegalArgumentException("Provided phi must be between -PI/2 and PI/2 radians");
		}
	}
	
	protected void assertIsValidTheta(double theta) {
		assertIsValidDouble(theta);
		if(theta < -Math.PI && theta > Math.PI) {
			throw new IllegalArgumentException("Provided theta must be between -PI and PI radians");
		}
	}
	
	protected void assertIsValidRadius(double radius) {
		assertIsValidDouble(radius);
		if(radius < 0) {
			throw new IllegalArgumentException("Provided radius must be greater or equal 0");
		}
	}

	@Override
	protected void assertClassInvariants() {
		assertCoordinateIsNotNull(this);
		assertHasValidDoubles();
		
		assertIsValidPhi(phi);
		assertIsValidTheta(theta);
		assertIsValidRadius(radius);	
	}
}
