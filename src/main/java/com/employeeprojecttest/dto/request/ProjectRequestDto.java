package com.employeeprojecttest.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import java.util.List;

@Getter
public class ProjectRequestDto {
    @Size(min = 1, max = 20, message
            = "Name must be between 1 and 20 characters")
    private String name;
    @Size(min = 15, max = 200, message
            = "Brief must be between 15 and 200 characters")
    private String briefDescription;
    private List<Long> employeeId;
}
