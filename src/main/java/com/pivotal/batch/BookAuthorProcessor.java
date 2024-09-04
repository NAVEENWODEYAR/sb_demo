package com.pivotal.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.pivotal.entity.BookEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * @author NaveenWodeyar
 * @date 04-Sept-2024
 */
@Slf4j
@Component
public class BookAuthorProcessor implements ItemProcessor<BookEntity, BookEntity> {

	private static final Logger log = LoggerFactory.getLogger(BookAuthorProcessor.class);
	@Override
	public BookEntity process(BookEntity item) throws Exception {
		log.info("Processing title for {}",item);
		item.setBookAuthor(item.getBookAuthor().toUpperCase());
		return item;
	}

}
