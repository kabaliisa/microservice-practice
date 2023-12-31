package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeRepository repository;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        LOGGER.info("Employee add: employee={}", employee);
        return repository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("Employee Find all");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("Employee findById: employeeId={}", id);
        return repository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId){
        LOGGER.info("Employee findByDepartment: departmentId={}", departmentId);
        return repository.findByDepartment(departmentId);
    }

}
