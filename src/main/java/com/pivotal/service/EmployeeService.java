package com.pivotal.service;
/*
 * @author Naveen K Wodeyar
 * @date 29/06/2024
 */
import com.pivotal.dto.EmployeeDto;
import com.pivotal.entity.Employee;
import com.pivotal.repo.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> getEmployeeList() {
        return employeeRepo.findAll();
    }

    public String saveEmployee(EmployeeDto request) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(request,employee);
        employeeRepo.save(employee);
        return "Employee added successfully!,";
    }

    public Employee getById(Long empId) {
        var employee = employeeRepo.findById(empId).orElseThrow();
        return employee;
    }

    public String updateEmployee(EmployeeDto request, Long empId) {
        return "";
    }

    public String deleteEmployee(Long empId) {
        employeeRepo.deleteById(empId);
        return "Employee deleted successfully!";
    }
}
