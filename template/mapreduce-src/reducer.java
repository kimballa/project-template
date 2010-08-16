// %copyright%

package %main.package%;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Reducer for %ProjName%.
 */
public class %ProjName%Reducer extends Reducer<KIN, VIN, KOUT, VOUT> {

  public static final Log LOG = LogFactory.getLog(
      %ProjName%Reducer.class.getName());
  
  @Override
  protected void setup(Context context)
      throws IOException, InterruptedException {
  }

  @Override
  public void reduce(KIN key, Iterable<VIN> vals, Context context)
      throws IOException, InterruptedException {
    // The identity function.
    super.map(key, vals, context);
  }
}
