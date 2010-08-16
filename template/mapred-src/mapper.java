// %copyright%

package %main.package%;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

/**
 * Mapper for %ProjectName%.
 */
public class %ProjectName%Mapper extends MapReduceBase
    implements Mapper<LongWritable, Text, LongWritable, Text> {

  public static final Log LOG = LogFactory.getLog(
      %ProjectName%Mapper.class.getName());
  
  @Override
  public void configure(JobConf job) {
  }

  @Override
  public void map(LongWritable key, Text val,
      OutputCollector<LongWritable, Text> output, Reporter reporter)
      throws IOException {
    output.collect(key, val);
  }
}
