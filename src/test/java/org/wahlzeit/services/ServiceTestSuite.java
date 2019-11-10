package org.wahlzeit.services;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.wahlzeit.services.*;
import org.wahlzeit.services.mailing.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  EmailServiceTestSuite.class,
  LogBuilderTest.class
})

public class ServiceTestSuite {
}
