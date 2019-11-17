package org.wahlzeit.model;

public interface Coordinate {
  public CartesianCoordinate asCartesianCoordinate();
  public double getCartesianDistance(Coordinate coord);
  public SphericCoordinate asSphericCoordinate();
  public double getCentralAngle(Coordinate coord);
  public boolean isEqual(Coordinate coord);
}
