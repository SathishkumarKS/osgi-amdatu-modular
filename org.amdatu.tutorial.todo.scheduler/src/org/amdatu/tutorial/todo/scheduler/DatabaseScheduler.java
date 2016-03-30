package org.amdatu.tutorial.todo.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.amdatu.scheduling.annotations.RepeatForever;
import org.amdatu.scheduling.annotations.RepeatInterval;
import org.amdatu.tutorial.todo.storage.api.TodoService;
import org.apache.felix.dm.annotation.api.Component;
import org.apache.felix.dm.annotation.api.ServiceDependency;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Component
@RepeatForever
@RepeatInterval(period=RepeatInterval.MINUTE, value=1)
public class DatabaseScheduler implements Job {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@ServiceDependency
	  private volatile TodoService todoService;
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println(dateFormat.format(new Date()) + ": " + todoService.countRecords() + " records");
	}
}