package com.pivotal.controller;
/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import com.pivotal.dto.EmployeeDto;
import com.pivotal.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> testEndPoint(){
        return new ResponseEntity<>("Welcome!,", HttpStatus.OK);
    }
    
    @GetMapping("/java")
    public String javaVersion() {
		log.info("Java Version");
		return "\nJava Version-->"+System.getProperty("java.version");
	}

    @GetMapping("/listing")
    @Cacheable(value = "Employee List")
    public ResponseEntity<Object> getEmployeeList(){
    	log.info("Employee list fetched from db");
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }

    @PostMapping("/add")
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDto request){
    	log.info("Employee persisted to db");
        return ResponseEntity.ok(employeeService.saveEmployee(request));
    }

    @GetMapping("/{empId}")
    @Cacheable(value = "Employee")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long empId){
    	log.error("Employee found from db");
        return ResponseEntity.ok(employeeService.getById(empId));
    }

    @PutMapping("/edit/{empId}")
    @CachePut(value = "Employee update")
    public ResponseEntity<Object> editEmployee(@PathVariable EmployeeDto request, @PathVariable Long empId){
        log.notify();
    	return ResponseEntity.ok(employeeService.updateEmployee(request, empId));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long empId){
    	log.debug("Deleted employee from db");
        return ResponseEntity.ok(employeeService.deleteEmployee(empId));
    }
}
