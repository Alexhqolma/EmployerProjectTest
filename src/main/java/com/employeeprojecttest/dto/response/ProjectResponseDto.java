package com.employeeprojecttest.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String briefDescription;
    private List<Long> employeeId;
}
