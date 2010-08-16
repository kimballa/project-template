// %copyright%

package %main.package%;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * %ProjectName%
 */
public class %ProjectName% extends Configured implements Tool {

  public static final Log LOG = LogFactory.getLog(
      %ProjectName%.class.getName());

  private int runMapRedJob() {
    JobConf job = new JobConf(getConf());
    job.setJarByClass(%ProjectName%.class);
    job.setMapperClass(%ProjectName%Mapper.class);
    job.setReducerClass(%ProjectName%Reducer.class);

    FileInputFormat.addInputPath(job, new Path("%proj.name%-input"));
    FileOutputFormat.setInputPath(job, new Path("%proj.name%-output"));

    JobClient.runJob(job);
    return 0;
  }

  @Override
  public int run(String [] args) throws Exception {
    return runMapRedJob();
  }

  public static void main(String [] args) throws Exception {
    System.exit(ToolRunner.run(new %ProjectName%(), args));
  }
}
