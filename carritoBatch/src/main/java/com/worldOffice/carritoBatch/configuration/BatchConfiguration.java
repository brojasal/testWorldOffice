package com.worldOffice.carritoBatch.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.worldOffice.carrito.dto.ProductoDTO;
import com.worldOffice.carritoBatch.metodosBatch.ProductoItemProcessor;
import com.worldOffice.carritoBatch.metodosBatch.ProductoItemReader;
import com.worldOffice.carritoBatch.metodosBatch.ProductoItemWriter;
import com.worldOffice.carritoBatch.metodosBatch.listeners.ProductoItemReaderListener;
import com.worldOffice.carritoBatch.metodosBatch.listeners.ProductoJobExecutionListener;

@Configuration
@EnableBatchProcessing
@ComponentScan ("com.worldOffice.carrito.converter")
@EntityScan ("com.worldOffice.carrito.entity")
@EnableJpaRepositories (basePackages = {"com.worldOffice.carrito.dao"})
public class BatchConfiguration {

	 @Autowired
	    public JobBuilderFactory jobBuilderFactory;

	    @Autowired
	    public StepBuilderFactory stepBuilderFactory;

	    @Bean
	    public ProductoItemReader reader() {
	        return new ProductoItemReader();
	    }

	    @Bean
	    public ProductoItemProcessor processor() {
	        return new ProductoItemProcessor();
	    }

	    @Bean
	    public ProductoItemWriter writer() {
	        return new ProductoItemWriter();
	    }

	    @Bean
	    public ProductoJobExecutionListener jobExecutionListener() {
	        return new ProductoJobExecutionListener();
	    }
	    
	    @Bean
	    public ProductoItemReaderListener readListener() {
	    	return new ProductoItemReaderListener();
	    }
	    
	    @Bean
	    public Job job(Step step, ProductoJobExecutionListener jobExecutionListener) {
	        Job job = jobBuilderFactory.get("job1")
	        		.listener(jobExecutionListener)
	                .flow(step)
	                .end()
	                .build();
	        return job;
	    }

	    @Bean
	    public Step step(ProductoItemReader reader,
	    				 ProductoItemWriter writer,
	    				 ProductoItemProcessor processor,
	    				 ProductoItemReaderListener itemReaderListener) {

	        TaskletStep step = stepBuilderFactory.get("step1")
	                .<ProductoDTO, ProductoDTO>chunk(5)
	                .reader(reader)
	                .processor(processor)
	                .writer(writer)
	                .listener(itemReaderListener)
	                .build();
	        return step;
	    }
}