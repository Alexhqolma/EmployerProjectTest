package com.employeeprojecttest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Column(name = "employee_type")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    @Column(name = "employee_level")
    @Enumerated(EnumType.STRING)
    private EmployeeLevel employeeLevel;
    @Column(name = "employee_profession")
    @Enumerated(EnumType.STRING)
    private EmployeeProfession employeeProfession;
    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;
}
