// %copyright%

package %main.package%;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * %ProjName%
 */
public class %ProjName% extends Configured implements Tool {

  public static final Log LOG = LogFactory.getLog(
      %ProjName%.class.getName());

  private int runMapRedJob() {
    Job job = new Job(getConf());
    job.setJarByClass(%ProjName%.class);
    job.setMapperClass(%ProjName%Mapper.class);
    job.setReducerClass(%ProjName%Reducer.class);

    FileInputFormat.addInputPath(job, new Path("%proj.name%-input"));
    FileOutputFormat.setInputPath(job, new Path("%proj.name%-output"));

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
    System.exit(ToolRunner.run(new %ProjName%(), args));
  }
}
