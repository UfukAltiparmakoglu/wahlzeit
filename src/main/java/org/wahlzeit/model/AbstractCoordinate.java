package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
	
	private final double PRECISION = 1E-5;
	
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		return (CartesianCoordinate) this;
	}
	
	public double getCartesianDistance(Coordinate coord) {
		assertClassInvariants();
		
		assertCoordinateIsNotNull(this);
		assertCoordinateIsNotNull(coord);
		
		double distance = this.asCartesianCoordinate().getDistance(coord.asCartesianCoordinate());
		
		assertIsValidDouble(distance);
		
		assertClassInvariants();
		
		return distance;
	}
	
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		return (SphericCoordinate) this;
	}
	
	//	calculated by chord length (wikipedia)
	public double getCentralAngle(Coordinate coord) {
		assertClassInvariants();
		
		assertCoordinateIsNotNull(this);
		assertCoordinateIsNotNull(coord);
		
		SphericCoordinate this_ = this.asSphericCoordinate();
		SphericCoordinate coord_ = coord.asSphericCoordinate();		
		
		double dX = Math.cos(this_.getTheta()) * Math.cos(this_.getPhi()) - Math.cos(coord_.getTheta()) * Math.cos(coord_.getPhi());
		double dY = Math.cos(this_.getTheta()) * Math.sin(this_.getPhi()) - Math.cos(coord_.getTheta()) * Math.sin(coord_.getPhi());
		double dZ = Math.sin(this_.getTheta()) - Math.sin(coord_.getTheta());
		double chordLength = Math.sqrt(dX*dX + dY*dY + dZ*dZ);
		
		double angle = Math.toDegrees(2 * Math.asin(chordLength/2));
		
		assertIsValidDouble(angle);
		
		assertClassInvariants();

		return angle;
	}
	
	@Override
	public boolean equals(Object coord) {
		return isEqual((Coordinate) coord);
	}
	
	public boolean isEqual(Coordinate coord) {
		assertClassInvariants();
		assertCoordinateIsNotNull(coord);
		
		if(coord == null || !(coord.asCartesianCoordinate() instanceof CartesianCoordinate)){
			return false;
		}

		return this.hasSameDoubleCoordinates(coord);
	}
	
	public boolean hasSameDoubleCoordinates(Coordinate coord){
		assertClassInvariants();
		
		assertCoordinateIsNotNull(this);
		assertCoordinateIsNotNull(coord);
		
		CartesianCoordinate this_ = this.asCartesianCoordinate();
		CartesianCoordinate coord_ = coord.asCartesianCoordinate();
		
		if(!this_.hasValidDoubles() || !coord_.hasValidDoubles()){
			return false;
		}
	
		boolean precisionX = Math.abs(this_.getX() - coord_.getX()) < PRECISION;
		boolean precisionY = Math.abs(this_.getY() - coord_.getY()) < PRECISION;
		boolean precisionZ = Math.abs(this_.getZ() - coord_.getZ()) < PRECISION;
		
		return precisionX && precisionY && precisionZ;
	}
	
	protected double getDistance(Coordinate coord) {
		assertClassInvariants();
		
		assertCoordinateIsNotNull(this);
		assertCoordinateIsNotNull(coord);
		
		CartesianCoordinate this_ = this.asCartesianCoordinate();
		CartesianCoordinate coord_ = coord.asCartesianCoordinate();
				
		double dX_squared = Math.pow(this_.getX() - coord_.getX(), 2);
		double dY_squared = Math.pow(this_.getY() - coord_.getY(), 2);
		double dZ_squared = Math.pow(this_.getZ() - coord_.getZ(), 2);
		
		double distance = Math.sqrt(dX_squared + dY_squared + dZ_squared);
		
		assertIsValidDouble(distance);
		
		assertClassInvariants();		
		
		return distance;
	}
	
	public void assertCoordinateIsNotNull(Coordinate coord) {
		if(coord == null) {
			throw new NullPointerException("Provided coordinate is null!");
		}
	}
	
	public void assertIsValidDouble(double val) {
		if(!Double.isFinite(val)) {
			throw new IllegalArgumentException("Provided value is not valid Double!");
		}
	}
	
	protected abstract void assertClassInvariants();
}
