package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.wahlzeit.handlers.HandlerSuite;
import org.wahlzeit.model.ModelSuite;
import org.wahlzeit.services.ServiceSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  org.wahlzeit.handlers.HandlerSuite.class,
  org.wahlzeit.model.ModelSuite.class,
  org.wahlzeit.services.ServiceSuite.class,
  org.wahlzeit.utils.UtilSuite.class
})

public class AllTests {
}
