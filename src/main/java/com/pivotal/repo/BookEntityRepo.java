package com.pivotal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pivotal.entity.BookEntity;
/**
 * @author NaveenWodeyar
 * @date 04-Sept-2024
 */
@Repository
public interface BookEntityRepo extends JpaRepository<BookEntity, Long> {

}
