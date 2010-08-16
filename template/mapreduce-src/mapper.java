// %copyright%

package %main.package%;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * Mapper for %ProjectName%.
 */
public class %ProjectName%Mapper extends Mapper<KIN, VIN, KOUT, VOUT> {

  public static final Log LOG = LogFactory.getLog(
      %ProjectName%Mapper.class.getName());
  
  @Override
  protected void setup(Context context)
      throws IOException, InterruptedException {
  }

  @Override
  public void map(KIN key, VIN val, Context context)
      throws IOException, InterruptedException {
    // The identity function.
    super.map(key, val, context);
  }
}
