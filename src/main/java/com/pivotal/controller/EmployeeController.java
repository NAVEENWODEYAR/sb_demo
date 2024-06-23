package com.pivotal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping
    public ResponseEntity<?> testEndPoint(){
        return new ResponseEntity<>("Welcome!,", HttpStatus.OK);
    }
}
