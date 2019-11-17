package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate implements Coordinate {

	private double phi;
	private double theta;
	private double radius;
	
	private final double PRECISION = 1E-5;

	public SphericCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}

	public CartesianCoordinate asCartesianCoordinate(){
		//double phi_ = Math.toRadians(this.phi);
		//double theta_ = Math.toRadians(this.theta);
		
		double phi_ = this.phi;
		double theta_ = this.theta;
		
		double x = Math.toDegrees(this.radius * Math.sin(theta_) * Math.cos(phi_));
		double y = Math.toDegrees(this.radius * Math.sin(theta_) * Math.sin(phi_));
		double z = this.radius * Math.cos(theta_);

		return new CartesianCoordinate(x,y,z);
	}

	public double getCartesianDistance(Coordinate coord){
		return this.asCartesianCoordinate().getDistance(coord.asCartesianCoordinate());
	}

	public SphericCoordinate asSphericCoordinate(){
		return new SphericCoordinate(this.phi, this.theta, this.radius);
	}

	//	calculated by chord length (wikipedia)
	public double getCentralAngle(Coordinate coord){
		double dX = Math.cos(this.theta) * Math.cos(this.phi) - Math.cos(coord.asSphericCoordinate().getTheta()) * Math.cos(coord.asSphericCoordinate().getPhi());
		double dY = Math.cos(this.theta) * Math.sin(this.phi) - Math.cos(coord.asSphericCoordinate().getTheta()) * Math.sin(coord.asSphericCoordinate().getPhi());
		double dZ = Math.sin(this.theta) - Math.sin(coord.asSphericCoordinate().getTheta());

		double chordLength = Math.sqrt(dX*dX + dY*dY + dZ*dZ);

		return Math.toDegrees(2 * Math.asin(chordLength/2));
	}
  
	protected double getDistance(SphericCoordinate coord) {
		return this.asCartesianCoordinate().getDistance(coord.asCartesianCoordinate());
	}

	@Override
	public boolean equals(Object coord) {
		return isEqual((SphericCoordinate) coord);
	}

	public boolean isEqual(Coordinate coord) {
		if(coord == null || !(coord.asSphericCoordinate() instanceof SphericCoordinate)){
			return false;
		}

		return this.hasSameDoubleCoordinates(coord.asSphericCoordinate());
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.phi, this.theta, this.radius);
	}
	
	public boolean hasSameDoubleCoordinates(SphericCoordinate coord){
		if(Double.isNaN(this.phi) || Double.isNaN(this.theta) || Double.isNaN(this.radius)
			|| Double.isNaN(coord.phi) || Double.isNaN(coord.theta) || Double.isNaN(coord.radius)){
				return false;
			}

			boolean precisionX = Math.abs(this.phi - coord.phi) < PRECISION;
			boolean precisionY = Math.abs(this.theta - coord.theta) < PRECISION;
			boolean precisionZ = Math.abs(this.radius - coord.radius) < PRECISION;

			return precisionX && precisionY && precisionZ;
	}

	public double getPhi() {
		return phi;
	}

	public void setPhi(double phi) {
		this.phi = phi;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
