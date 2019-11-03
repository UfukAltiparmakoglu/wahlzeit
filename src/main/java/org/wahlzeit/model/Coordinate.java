package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

	private double x;
	private double y;
	private double z;

	private final double PRECISION = 1E-5;

	public Coordinate(double x, double y, double z) {
		this.setCoordinates(x, y, z);
	}

	protected double getDistance(Coordinate coord) {
		double dX_squared = Math.pow(this.getX() - coord.getX(), 2);
		double dY_squared = Math.pow(this.getY() - coord.getY(), 2);
		double dZ_squared = Math.pow(this.getZ() - coord.getZ(), 2);

		return Math.sqrt(dX_squared + dY_squared + dZ_squared);
	}

	@Override
	public boolean equals(Object coord) {
		return isEqual((Coordinate) coord);
	}

	protected boolean isEqual(Coordinate coord) {
		if(coord == null || !(coord instanceof Coordinate)){
			return false;
		}

		return this.getX() == coord.getX()
				&& this.getY() == coord.getY()
				&& this.getZ() == coord.getZ();
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.x, this.y, this.z);
	}

	public boolean hasSameDoubleCoordinates(Coordinate coord){
		if(Double.isNaN(this.x) || Double.isNaN(this.y) || Double.isNaN(this.z)
			|| Double.isNaN(coord.x) || Double.isNaN(coord.y) || Double.isNaN(coord.z)){
				return false;
			}

			boolean precisionX = Math.abs(this.x - coord.x) < PRECISION;
			boolean precisionY = Math.abs(this.y - coord.y) < PRECISION;
			boolean precisionZ = Math.abs(this.z - coord.z) < PRECISION;

			return precisionX && precisionY && precisionZ;
	}

	public double[] getCoordinates() {
		return new double[]{x,y,z};
	}

	public void setCoordinates(double x, double y, double z) {
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
