package com.employeeprojecttest.dto.response;

import com.employeeprojecttest.model.EmployeeLevel;
import com.employeeprojecttest.model.EmployeeProfession;
import com.employeeprojecttest.model.EmployeeType;
import lombok.Data;
import java.util.List;

@Data
public class EmployeeResponseDto {
    private Long id;
    private String name;
    private int age;
    private EmployeeType employeeType;
    private EmployeeLevel employeeLevel;
    private EmployeeProfession employeeProfession;
    private List<Long> projectId;
}
