package com.example.propartes.projects;

import com.example.propartes.projects.DTO.ProjectDTO;
import com.example.propartes.projects.DTO.ProjectFilter;
import com.example.propartes.projects.data.Project;
import com.example.propartes.projects.service.projectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class projectController {


    @Autowired
    private projectService projectService;


    @Operation(summary = "Create a project", description = "Create a project using form-data")
    @PostMapping("/create")
    public void createProject(
            @Parameter(description = "Project DTO object") @ModelAttribute ProjectDTO projectDTO) {
        projectService.create(projectDTO);
    }

    @Operation(summary = "Update a project", description = "Update a project using form-data")
    @PostMapping("/update")
    public void updateProject(
            @Parameter(description = "ID of the project", required = true) @RequestPart("id") String id,
            @Parameter(description = "Project object", required = true) @ModelAttribute Project project) {
        project.set_id(id);
        projectService.update(project);
    }

    @Operation(summary = "Get all projects", description = "Retrieve projects based on filtering criteria")
    @GetMapping("/projects")
    public List<Project> getAllProjects(
            @Parameter(description = "Filter criteria for projects") @RequestBody ProjectFilter projectFilter) {
        return projectService.findProjects(projectFilter);
    }
}
