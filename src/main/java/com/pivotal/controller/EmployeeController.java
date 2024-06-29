package com.pivotal.controller;
/*
 * @author Naveen K Wodeyar
 * @date 23/06/2024
 */
import com.pivotal.dto.EmployeeDto;
import com.pivotal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/test")
    public ResponseEntity<?> testEndPoint(){
        return new ResponseEntity<>("Welcome!,", HttpStatus.OK);
    }

    @GetMapping("/listing")
    public ResponseEntity<Object> getEmployeeList(){
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }

    @PostMapping("/save")
    public ResponseEntity<Object> saveEmployee(@RequestBody EmployeeDto request){
        return ResponseEntity.ok(employeeService.saveEmployee(request));
    }

    @GetMapping("/getById/{empId}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable Long empId){
        return ResponseEntity.ok(employeeService.getById(empId));
    }


    @PutMapping("/edit/{empId}")
    public ResponseEntity<Object> editEmployee(@PathVariable EmployeeDto request, @PathVariable Long empId){
        return ResponseEntity.ok(employeeService.updateEmployee(request, empId));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long empId){
        return ResponseEntity.ok(employeeService.deleteEmployee(empId));
    }
}
