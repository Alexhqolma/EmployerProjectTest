package com.employeeprojecttest.dto.mapper;

import com.employeeprojecttest.dto.request.ProjectRequestDto;
import com.employeeprojecttest.dto.response.ProjectResponseDto;
import com.employeeprojecttest.model.Employee;
import com.employeeprojecttest.model.Project;
import com.employeeprojecttest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProjectMapper {
    private final EmployeeService employeeService;

    public Project toModel(ProjectRequestDto dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setBriefDescription(dto.getBriefDescription());
        project.setEmployees(dto.getEmployeeId()
                .stream()
                .map(employeeService::findById)
                .collect(Collectors.toList()));
        return project;
    }

    public ProjectResponseDto toDto(Project project) {
        ProjectResponseDto dto = new ProjectResponseDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setBriefDescription(project.getBriefDescription());
        dto.setEmployeeId(project.getEmployees()
                .stream()
                .map(Employee::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
