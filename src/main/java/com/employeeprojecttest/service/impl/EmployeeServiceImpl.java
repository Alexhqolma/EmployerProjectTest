package com.employeeprojecttest.service.impl;

import com.employeeprojecttest.exception.EmployeeProjectException;
import com.employeeprojecttest.model.Employee;
import com.employeeprojecttest.model.Project;
import com.employeeprojecttest.repository.EmployeeRepository;
import com.employeeprojecttest.repository.ProjectRepository;
import com.employeeprojecttest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeProjectException("Can't find employee by id " + id));
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeProjectException("Employee not found with id " + id));
        List<Project> projects = projectRepository.findAllByEmployeesContaining(employee);
        projects.forEach(project -> {
            project.getEmployees().remove(employee);
            projectRepository.save(project);
        });
        employeeRepository.deleteById(id);
    }
}
