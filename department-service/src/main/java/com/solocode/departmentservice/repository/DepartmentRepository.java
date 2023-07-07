package com.solocode.departmentservice.repository;

import com.solocode.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private List<Department> departments = new ArrayList<>();

    public List<Department> findAll() {
        return departments;
    }

    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream()
                .filter(d -> d.getId().equals(id))
                .findFirst().orElseThrow();
    }
}
