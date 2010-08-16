// %copyright%

package %main.package%;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/**
 * Mapper for %ProjName%.
 */
public class %ProjName%Mapper extends MapReduceBase
    implements Mapper<KIN, VIN, KOUT, VOUT> {

  public static final Log LOG = LogFactory.getLog(
      %ProjName%Mapper.class.getName());
  
  @Override
  public void configure(JobConf job) {
  }

  @Override
  public void map(KIN key, VIN val, OutputCollector<KOUT, VOUT> output,
      Reporter reporter) throws IOException {
    output.collect(key, val);
  }
}
