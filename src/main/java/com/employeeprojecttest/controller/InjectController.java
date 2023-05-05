package com.employeeprojecttest.controller;

import com.employeeprojecttest.model.*;
import com.employeeprojecttest.service.EmployeeService;
import com.employeeprojecttest.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inject")
public class InjectController {
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    @GetMapping
    public String inject() {
        Employee employeeNikolay = new Employee();
        employeeNikolay.setName("Nikolay");
        employeeNikolay.setAge(39);
        employeeNikolay.setEmployeeType(EmployeeType.PROGRAMMER);
        employeeNikolay.setEmployeeLevel(EmployeeLevel.SENIOR);
        employeeNikolay.setEmployeeProfession(EmployeeProfession.DEVELOPER);
        employeeService.save(employeeNikolay);

        Employee employeeGreg = new Employee();
        employeeGreg.setName("Greg");
        employeeGreg.setAge(55);
        employeeGreg.setEmployeeType(EmployeeType.MANAGER);
        employeeGreg.setEmployeeLevel(EmployeeLevel.SENIOR);
        employeeGreg.setEmployeeProfession(EmployeeProfession.QA);
        employeeService.save(employeeGreg);

        Project projectEmail = new Project();
        projectEmail.setName("Email");
        projectEmail.setBriefDescription("Email for research and develop team");
        List<Employee> employees = new ArrayList<>();
        employees.add(employeeGreg);
        employees.add(employeeNikolay);
        projectEmail.setEmployees(employees);
        projectService.save(projectEmail);

        Project projectPostman = new Project();
        projectPostman.setName("Postman");
        projectPostman.setBriefDescription("Postman for Army troops on the war");
        projectPostman.setEmployees(employees);
        projectService.save(projectPostman);

        projectService.delete(projectPostman.getId());

        return "Done!";
    }
}
