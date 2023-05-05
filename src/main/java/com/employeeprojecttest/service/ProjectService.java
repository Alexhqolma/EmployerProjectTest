package com.employeeprojecttest.service;

import com.employeeprojecttest.model.Employee;
import com.employeeprojecttest.model.Project;
import java.util.List;

public interface ProjectService {
    Project findById(Long id);

    Project save(Project project);

    List<Project> findAll();

    Project update(Project project);

    void delete(Long id);

    List<Project> findAllByEmployeesContaining(Employee employee);
}
