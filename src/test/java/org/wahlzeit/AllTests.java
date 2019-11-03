package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.wahlzeit.handlers.HandlerSuite;
import org.wahlzeit.model.ModelSuite;
import org.wahlzeit.services.ServiceSuite;
import org.wahlzeit.utils.UtilSuite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
  HandlerSuite.class,
  ModelSuite.class,
  ServiceSuite.class,
  UtilSuite.class
})

public class AllTests {
}
