package com.pivotal.config;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.support.CompositeItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.pivotal.batch.BookAuthorProcessor;
import com.pivotal.batch.BookTitleProcessor;
import com.pivotal.batch.BookWriter;
import com.pivotal.entity.BookEntity;

/**
 * @author NaveenWodeyar
 * @date 04-Sept-2024
 */
@Configuration
@EnableBatchProcessing
public class BatchConfing {
	
	@Bean
	public Job bookReader(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobBuilder("bookReaderJob",jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(chunkStep(jobRepository, transactionManager))
				.build();
	}
	
	@Bean
	@StepScope
	public ItemProcessor<BookEntity, BookEntity> processor(){
		CompositeItemProcessor<BookEntity, BookEntity> processor = new CompositeItemProcessor<BookEntity, BookEntity>();
		processor.setDelegates(List.of(new BookTitleProcessor(),new BookAuthorProcessor()));
		return processor();
	}
	
	
	@Bean
	@StepScope
	public ItemWriter<BookEntity> writer(){
		return new BookWriter();
	}
	
	@Bean
	public Step chunkStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("bookRederStep",jobRepository)
				.<BookEntity,BookEntity>chunk(10,platformTransactionManager)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	@Bean
	@StepScope
	public FlatFileItemReader<BookEntity> reader(){
		return new FlatFileItemReaderBuilder<BookEntity>()
				.name("bookReader")
				.resource(new ClassPathResource("MOCK_DATA.csv"))
				.delimited()
				.names(new String[] {"product_id","product_title"," product_description","product_price","product_discount"," product_discounted_amount"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<BookEntity>() {{
					setTargetType(BookEntity.class);
				}})
				.linesToSkip(1)
				.build();
	}

}
