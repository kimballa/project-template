// %copyright%

package %main.package%;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;

/**
 * Tests for %ProjectName%
 */
public class Test%ProjectName% extends TestCase {

  public static final Log LOG = LogFactory.getLog(
      Test%ProjectName%.class.getName());

  public void setUp() throws Exception {
  }

  public void tearDown() throws Exception {
  }

  public void test%ProjectName%() throws Exception {
    LOG.debug("Tests go here.");
  }
}
