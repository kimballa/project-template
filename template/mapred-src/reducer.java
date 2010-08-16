// %copyright%

package %main.package%;

import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.Reducer;

/**
 * Reducer for %ProjectName%.
 */
public class %ProjectName%Reducer extends MapReduceBase
    implements Reducer<KIN, VIN, KOUT, VOUT> {

  public static final Log LOG = LogFactory.getLog(
      %ProjectName%Reducer.class.getName());
  
  @Override
  public void configure(JobConf job) {
  }

  @Override
  public void reduce(KIN key, Iterator<VIN> vals,
      OutputCollector<KOUT, VOUT> output, Reporter reporter)
      throws IOException { 
  }
}
