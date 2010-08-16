// %copyright%

package %main.package%;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

/**
 * Tests for %ProjName%
 */
public class Test%ProjName% extends TestCase {

  public static final Log LOG = LogFactory.getLog(
      Test%ProjName%.class.getName());

  public void setUp() throws Exception {
  }

  public void tearDown() throws Exception {
  }

  public void test%ProjName%() throws Exception {
    LOG.debug("Tests go here.");
  }
}
