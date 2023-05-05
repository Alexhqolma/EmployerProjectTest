package com.employeeprojecttest.service.impl;

import com.employeeprojecttest.exception.EmployeeProjectException;
import com.employeeprojecttest.model.Employee;
import com.employeeprojecttest.model.Project;
import com.employeeprojecttest.repository.ProjectRepository;
import com.employeeprojecttest.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new EmployeeProjectException("Can't find project by id " + id));
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public List<Project> findAllByEmployeesContaining(Employee employee) {
        return projectRepository.findAllByEmployeesContaining(employee);
    }
}
