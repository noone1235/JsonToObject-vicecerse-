package schedulerTest;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sample implements Job{

	private static final Logger log=LoggerFactory.getLogger(Sample.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("hello World");
		
	}
	
}
