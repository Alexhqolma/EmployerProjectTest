package com.employeeprojecttest.dto.request;

import com.employeeprojecttest.model.EmployeeLevel;
import com.employeeprojecttest.model.EmployeeProfession;
import com.employeeprojecttest.model.EmployeeType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import java.util.List;

@Getter
public class EmployeeRequestDto {
    @Size(min = 1, max = 20, message
            = "Name must be between 1 and 20 characters")
    private String name;
    @Min(value = 10, message = "age must be min 10 years")
    private int age;
    private EmployeeType employeeType;
    private EmployeeLevel employeeLevel;
    private EmployeeProfession employeeProfession;
    private List<Long> projectId;
}
