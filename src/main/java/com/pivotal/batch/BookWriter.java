package com.pivotal.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pivotal.entity.BookEntity;
import com.pivotal.repo.BookEntityRepo;

/**
 * @author NaveenWodeyar
 * @date 04-Sept-2024
 */
@Component
public class BookWriter implements ItemWriter<BookEntity> {

	private static final Logger log = LoggerFactory.getLogger(BookWriter.class);

	@Autowired
	private BookEntityRepo bookEntityRepo;
	
	@Override
	public void write(Chunk<? extends BookEntity> chunk) throws Exception {
		log.info("Writing {}",chunk.getItems().size());
		bookEntityRepo.saveAll(chunk.getItems());
	}

}
