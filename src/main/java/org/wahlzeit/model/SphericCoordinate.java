package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

	private double phi;
	private double theta;
	private double radius;

	public SphericCoordinate(double phi, double theta, double radius) {
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
		
		CartesianCoordinate cc = new CartesianCoordinate(x,y,z);
		
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

	public void setPhi(double phi) {
		assertIsValidPhi(radius);
		this.phi = phi;
	}

	public double getTheta() {
		assertClassInvariants();
		return theta;
	}

	public void setTheta(double theta) {
		assertIsValidTheta(radius);
		this.theta = theta;
	}

	public double getRadius() {
		assertClassInvariants();
		return radius;
	}

	public void setRadius(double radius) {
		assertIsValidRadius(radius);
		this.radius = radius;
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
		
		assertIsValidPhi(phi);
		assertIsValidTheta(theta);
		assertIsValidRadius(radius);	
	}
}
