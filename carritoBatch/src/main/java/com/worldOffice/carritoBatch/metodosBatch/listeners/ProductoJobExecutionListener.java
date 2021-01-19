package com.worldOffice.carritoBatch.metodosBatch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ProductoJobExecutionListener implements JobExecutionListener{

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoJobExecutionListener.class);
	@Override
	public void beforeJob(JobExecution jobExecution) {
		LOGGER.info("beforeJob");
		
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		LOGGER.info("afterJob: " + jobExecution.getStatus());		
	}

}
