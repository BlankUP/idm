package com.idm.app.idpconfig.taskQuartz.QuartzTask;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		System.out.println(new Date() + ": job 1 doing something...");
	}

}
