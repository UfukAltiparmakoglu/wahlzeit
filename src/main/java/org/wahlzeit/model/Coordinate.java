package org.wahlzeit.model;

import java.util.Objects;

public class Coordinate {

	private double x;
	private double y;
	private double z;

	public Coordinate(double x, double y, double z) {
		this.setCoordinates(x, y, z);
	}

	public double getDistance(Coordinate coord) {
		double dX_squared = Math.pow(this.getX() - coord.getX(), 2);
		double dY_squared = Math.pow(this.getY() - coord.getY(), 2);
		double dZ_squared = Math.pow(this.getZ() - coord.getZ(), 2);

		return Math.sqrt(dX_squared + dY_squared + dZ_squared);
	}

	@Override
	public boolean equals(Object coord) {
		return isEqual((Coordinate) coord);
	}

	public boolean isEqual(Coordinate coord) {
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
