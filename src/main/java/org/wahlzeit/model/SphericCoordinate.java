package org.wahlzeit.model;

import java.util.Objects;

public class SphericCoordinate extends AbstractCoordinate {

	private double phi;
	private double theta;
	private double radius;

	public SphericCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate(){
		double phi_ = this.phi;
		double theta_ = this.theta;
		
		double x = Math.toDegrees(this.radius * Math.sin(theta_) * Math.cos(phi_));
		double y = Math.toDegrees(this.radius * Math.sin(theta_) * Math.sin(phi_));
		double z = this.radius * Math.cos(theta_);

		return new CartesianCoordinate(x,y,z);
	}	

	@Override
	public int hashCode(){
		return Objects.hash(this.phi, this.theta, this.radius);
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
