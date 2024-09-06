package com.pivotal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pivotal.entity.Customer;

/**
 * @author NaveenWodeyar
 * @date 06-Sept-2024
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
