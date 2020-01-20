package org.wahlzeit.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.wahlzeit.model.*;
import org.wahlzeit.model.persistence.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({
  //AbstractAdapterTest.class, //this throws exceptions
  DatastoreAdapterTest.class,
  AccessRightsTest.class,
  CartesianCoordinateTest.class,
  SphericCoordinateTest.class,
  FlagReasonTest.class,
  GenderTest.class,
  GuestTest.class,
  PhotoFilterTest.class,
  TagsTest.class,
  UserStatusTest.class,
  ValueTest.class,
  MotorcyclePhotoTest.class,
  MotorcyclePhotoFactoryTest.class,
  MotorcyclePhotoManagerTest.class,
  MotorcycleTest.class,
  MotorcycleManagerTest.class,
  MotorcycleTypeTest.class,
  LocationTest.class
})

public class ModelTestSuite {
}
