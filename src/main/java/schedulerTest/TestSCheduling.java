package schedulerTest;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class TestSCheduling {
	public static void main(String[] args) {
        try {
        	  SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

        	  Scheduler sched = schedFact.getScheduler();

        	  sched.start();

        	  // define the job and tie it to our HelloJob class
        	  JobDetail job = newJob(Sample.class)
        	      .withIdentity("myJob", "group1")
        	      .build();
        	 
        	  // Trigger the job to run now, and then every 40 seconds
        	  Trigger trigger = newTrigger()
        	      .withIdentity("myTrigger", "group1")
        	      .startNow()
        	      .withSchedule(simpleSchedule()
        	          .withIntervalInSeconds(40)
        	          .repeatForever())
        	      .build();

        	  // Tell quartz to schedule the job using our trigger
        	  sched.scheduleJob(job, trigger);
            
            
        } catch (SchedulerException se) {
            se.printStackTrace();
        }
	}
}
