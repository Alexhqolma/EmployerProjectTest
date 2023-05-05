package com.employeeprojecttest.service;

import com.employeeprojecttest.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee findById(Long id);

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee update(Employee employee);

    void delete(Long id);
}
