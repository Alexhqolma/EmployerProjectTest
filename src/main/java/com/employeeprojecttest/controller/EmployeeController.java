package com.employeeprojecttest.controller;

import com.employeeprojecttest.dto.mapper.EmployeeMapper;
import com.employeeprojecttest.dto.request.EmployeeRequestDto;
import com.employeeprojecttest.dto.response.EmployeeResponseDto;
import com.employeeprojecttest.model.Employee;
import com.employeeprojecttest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDto create(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeMapper.toDto(employeeService.save(employeeMapper.toModel(employeeRequestDto)));
    }

    @GetMapping("/{id}")
    public EmployeeResponseDto findById(@PathVariable Long id) {
        return employeeMapper.toDto(employeeService.findById(id));
    }

    @GetMapping
    public List<EmployeeResponseDto> findAllEmployees() {
        return employeeService.findAll()
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public EmployeeResponseDto update(@PathVariable Long id,
                                      @RequestBody EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeMapper.toModel(employeeRequestDto);
        employee.setId(id);
        return employeeMapper.toDto(employeeService.update(employee));
    }
}
