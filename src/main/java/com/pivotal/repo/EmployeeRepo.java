package com.pivotal.repo;

import com.pivotal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "myBooks",collectionResourceRel = "book")
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
