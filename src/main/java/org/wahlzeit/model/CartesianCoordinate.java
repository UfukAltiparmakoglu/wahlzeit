package org.wahlzeit.model;

import java.util.Objects;

public class CartesianCoordinate implements Coordinate {

	private double x;
	private double y;
	private double z;

	private final double PRECISION = 1E-5;

	public CartesianCoordinate(double x, double y, double z) {
		this.setCartesianCoordinates(x, y, z);
	}

	public CartesianCoordinate asCartesianCoordinate(){
		return new CartesianCoordinate(this.x, this.y, this.z);
	}

	public double getCartesianDistance(Coordinate coord){
		return this.getDistance(coord.asCartesianCoordinate());
	}

	public SphericCoordinate asSphericCoordinate(){
		double x_sq = Math.pow(this.x, 2);
		double y_sq = Math.pow(this.y, 2);
		double z_sq = Math.pow(this.z, 2);
		double radius = Math.sqrt(x_sq + y_sq + z_sq);
		double phi = Math.toDegrees(Math.atan(this.y/this.x));
		double theta = Math.toDegrees(Math.acos(this.z/radius));
		return new SphericCoordinate(phi, theta, radius);
	}

	public double getCentralAngle(Coordinate coord){
		return this.asSphericCoordinate().getCentralAngle(coord);
	}

	protected double getDistance(CartesianCoordinate coord) {
		double dX_squared = Math.pow(this.getX() - coord.getX(), 2);
		double dY_squared = Math.pow(this.getY() - coord.getY(), 2);
		double dZ_squared = Math.pow(this.getZ() - coord.getZ(), 2);

		return Math.sqrt(dX_squared + dY_squared + dZ_squared);
	}

	@Override
	public boolean equals(Object coord) {
		return isEqual((CartesianCoordinate) coord);
	}

	public boolean isEqual(Coordinate coord) {
		if(coord == null || !(coord.asCartesianCoordinate() instanceof CartesianCoordinate)){
			return false;
		}

		return this.hasSameDoubleCoordinates(coord.asCartesianCoordinate());
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.x, this.y, this.z);
	}

	public boolean hasSameDoubleCoordinates(CartesianCoordinate coord){
		if(Double.isNaN(this.x) || Double.isNaN(this.y) || Double.isNaN(this.z)
			|| Double.isNaN(coord.x) || Double.isNaN(coord.y) || Double.isNaN(coord.z)){
				return false;
			}

			boolean precisionX = Math.abs(this.x - coord.x) < PRECISION;
			boolean precisionY = Math.abs(this.y - coord.y) < PRECISION;
			boolean precisionZ = Math.abs(this.z - coord.z) < PRECISION;

			return precisionX && precisionY && precisionZ;
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
