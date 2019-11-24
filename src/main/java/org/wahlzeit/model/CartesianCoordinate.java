package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate extends AbstractCoordinate {

	private double x;
	private double y;
	private double z;

	public CartesianCoordinate(double x, double y, double z) {
		this.setCartesianCoordinates(x, y, z);
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate(){
		double x_sq = Math.pow(this.x, 2);
		double y_sq = Math.pow(this.y, 2);
		double z_sq = Math.pow(this.z, 2);
		double radius = Math.sqrt(x_sq + y_sq + z_sq);
		double phi = Math.toDegrees(Math.atan(this.y/this.x));
		double theta = Math.toDegrees(Math.acos(this.z/radius));
		return new SphericCoordinate(phi, theta, radius);
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.x, this.y, this.z);
	}	

	public double[] getCartesianCoordinates() {
		return new double[]{x,y,z};
	}

	public void setCartesianCoordinates(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}
