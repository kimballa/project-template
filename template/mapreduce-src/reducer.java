// %copyright%

package %main.package%;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * Reducer for %ProjectName%.
 */
public class %ProjectName%Reducer
    extends Reducer<LongWritable, Text, LongWritable, Text> {

  public static final Log LOG = LogFactory.getLog(
      %ProjectName%Reducer.class.getName());
  
  @Override
  protected void setup(Context context)
      throws IOException, InterruptedException {
  }

  @Override
  public void reduce(LongWritable key, Iterable<Text> vals, Context context)
      throws IOException, InterruptedException {
    // The identity function.
    super.reduce(key, vals, context);
  }
}
