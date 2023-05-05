package com.employeeprojecttest.repository;

import com.employeeprojecttest.model.Employee;
import com.employeeprojecttest.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByEmployeesContaining(Employee employee);
}
