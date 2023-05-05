package com.employeeprojecttest.dto.mapper;

import com.employeeprojecttest.dto.request.EmployeeRequestDto;
import com.employeeprojecttest.dto.response.EmployeeResponseDto;
import com.employeeprojecttest.model.Employee;
import com.employeeprojecttest.model.Project;
import com.employeeprojecttest.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EmployeeMapper {
    private final ProjectService projectService;

    public Employee toModel(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setAge(dto.getAge());
        employee.setEmployeeType(dto.getEmployeeType());
        employee.setEmployeeLevel(dto.getEmployeeLevel());
        employee.setEmployeeProfession(dto.getEmployeeProfession());
        employee.setProjects(dto.getProjectId()
                .stream()
                .map(projectService::findById)
                .collect(Collectors.toList()));
        return employee;
    }

    public EmployeeResponseDto toDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setAge(employee.getAge());
        dto.setEmployeeType(employee.getEmployeeType());
        dto.setEmployeeLevel(employee.getEmployeeLevel());
        dto.setEmployeeProfession(employee.getEmployeeProfession());
        dto.setProjectId(employee.getProjects()
                .stream()
                .map(Project::getId)
                .collect(Collectors.toList()));
        return dto;
    }
}
