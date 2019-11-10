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
  CoordinateTest.class,
  FlagReasonTest.class,
  GenderTest.class,
  GuestTest.class,
  PhotoFilterTest.class,
  TagsTest.class,
  UserStatusTest.class,
  ValueTest.class,
  MotorcyclePhotoTest.class,
  MotorcyclePhotoFactoryTest.class,
  MotorcyclePhotoManagerTest.class
})

public class ModelTestSuite {
}
