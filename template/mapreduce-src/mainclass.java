// %copyright%

package %main.package%;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * %ProjectName%
 */
public class %ProjectName% extends Configured implements Tool {

  public static final Log LOG = LogFactory.getLog(
      %ProjectName%.class.getName());

  private int runMapRedJob() throws ClassNotFoundException, IOException,
      InterruptedException {
    Job job = new Job(getConf());
    job.setJarByClass(%ProjectName%.class);
    job.setMapperClass(%ProjectName%Mapper.class);
    job.setReducerClass(%ProjectName%Reducer.class);

    FileInputFormat.addInputPath(job, new Path("%proj.name%-input"));
    FileOutputFormat.setOutputPath(job, new Path("%proj.name%-output"));

    if (!job.waitForCompletion(true)) {
      LOG.error("Job failed!");
      return 1;
    }

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
