package com.example.employeeservice.repository;

import com.example.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private List<Employee> employeeList = new ArrayList<>();

    public List<Employee> findAll() {
        return employeeList;
    }
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public List<Employee> findByDepartment(Long departmentId){
        return employeeList.stream()
                .filter(e -> e.departmentId().equals(departmentId))
                .toList();
    }

    public Employee findById(Long id){
        return employeeList.stream()
                .filter(e -> e.id().equals(id))
                .findFirst()
                .orElseThrow();
    }

}
