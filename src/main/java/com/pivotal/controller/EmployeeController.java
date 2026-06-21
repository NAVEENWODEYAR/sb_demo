package com.pivotal.controller;
/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import com.pivotal.dto.EmployeeDto;
import com.pivotal.service.EmployeeService;

import jakarta.websocket.server.PathParam;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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
    public Map<String, String> javaVersion() {
        log.info("Java Version");
        Map<String, String> response = new HashMap<>();
        response.put("javaVersion", System.getProperty("java.version"));
        return response;
    }

    @GetMapping("/listing")
    @Cacheable(value = "Employee List")
    public ResponseEntity<Object> getEmployeeList(){
    	log.info("Employee details list fetched from db");
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<Object> saveEmployee(@PathParam("name") String name){
    	log.info("Employee  detail from db");
        return ResponseEntity.ok(employeeService.getByName(name));
    }
    
    @PostMapping("/save")
    public ResponseEntity<Object> saveEmp(@RequestBody EmployeeDto request){
    	log.info("Employee persisted to db");
        return ResponseEntity.ok(employeeService.saveEmployee(request));
    }

    @GetMapping("/{empId}")
    @Cacheable(value = "Employee",key = "#Id")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long empId){
    	log.error("Employee details found from db");
        return ResponseEntity.ok(employeeService.getById(empId));
    }

    @PutMapping("/edit/{empId}")
    @CachePut(value = "Employee update")
    public ResponseEntity<Object> editEmployee(@PathVariable EmployeeDto request, @PathVariable Long empId){
        log.notify();
    	return ResponseEntity.ok(employeeService.updateEmployee(request, empId));
    }

    @CacheEvict(value = "Employee",key = "#Id",condition = "#Id>=5")
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long empId){
    	log.debug("Deleted employee details from db");
        return ResponseEntity.ok(employeeService.deleteEmployee(empId));
    }
}
