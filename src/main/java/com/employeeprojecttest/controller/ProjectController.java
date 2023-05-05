package com.employeeprojecttest.controller;

import com.employeeprojecttest.dto.mapper.ProjectMapper;
import com.employeeprojecttest.dto.request.ProjectRequestDto;
import com.employeeprojecttest.dto.response.ProjectResponseDto;
import com.employeeprojecttest.model.Project;
import com.employeeprojecttest.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectController {
    private final ProjectMapper projectMapper;
    private final ProjectService projectService;

    @PostMapping
    public ProjectResponseDto create(@RequestBody ProjectRequestDto projectRequestDto) {
        return projectMapper.toDto(projectService.save(projectMapper.toModel(projectRequestDto)));
    }

    @GetMapping("/{id}")
    public ProjectResponseDto findById(@PathVariable Long id) {
        return projectMapper.toDto(projectService.findById(id));
    }

    @GetMapping
    public List<ProjectResponseDto> findAllProjects() {
        return projectService.findAll()
                .stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ProjectResponseDto update(@PathVariable Long id,
                                     @RequestBody ProjectRequestDto projectRequestDto) {
        Project project = projectMapper.toModel(projectRequestDto);
        project.setId(id);
        return projectMapper.toDto(projectService.update(project));
    }
}
