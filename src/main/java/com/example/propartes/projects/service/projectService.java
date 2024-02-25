package com.example.propartes.projects.service;


import com.example.propartes.config.SpacecUploader;
import com.example.propartes.projects.DTO.ProjectDTO;
import com.example.propartes.projects.DTO.ProjectFilter;
import com.example.propartes.projects.data.FloorPlan;
import com.example.propartes.projects.data.Plan;
import com.example.propartes.projects.data.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class projectService {

    @Autowired
    private projectRepo projectRepo;

    @Autowired
    private SpacecUploader spacecUploader;

    public  void  create(ProjectDTO projectDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0;i<projectDTO.getPictures().size();i++) {
           if (projectDTO.getPictures().get(i) instanceof MultipartFile) {
                String url = spacecUploader.uploadAndReturnUrl((MultipartFile) projectDTO.getPictures().get(i));
                projectDTO.getPictures().remove(i);
                projectDTO.getPictures().add(i,url);
            }
        }

        for (Map.Entry<String, FloorPlan> entry : projectDTO.getFloorPlans().entrySet()) {

            for (Plan plan:entry.getValue().getPlans()) {
                if (plan.getImage() instanceof MultipartFile) {
                    String url = spacecUploader.uploadAndReturnUrl((MultipartFile) plan.getImage());
                    plan.setImage(url);
                }
            }
        }
       projectRepo.save(objectMapper.convertValue(projectDTO, Project.class));
    }

    public void update(Project project){
        if(project.getPictures()!=null) {
            for (int i = 0; i < project.getPictures().size(); i++) {
                if (project.getPictures().get(i) instanceof MultipartFile) {
                    String url = spacecUploader.uploadAndReturnUrl((MultipartFile) project.getPictures().get(i));
                    project.getPictures().remove(i);
                    project.getPictures().add(i, url);
                }
            }
        }
        if(project.getFloorPlans()!=null) {

            for (Map.Entry<String, FloorPlan> entry : project.getFloorPlans().entrySet()) {

                for (Plan plan : entry.getValue().getPlans()) {
                    if (plan.getImage() instanceof MultipartFile) {
                        String url = spacecUploader.uploadAndReturnUrl((MultipartFile) plan.getImage());
                        plan.setImage(url);
                    }
                }
            }
        }
        projectRepo.save(project);

    }
    public List<Project> findProjects(ProjectFilter projectFilter)
    {
        return projectRepo.getFilteredProjects(projectFilter.getBedrooms(),projectFilter.getCompletion(),projectFilter.getLocation(),projectFilter.getType(),projectFilter.getPriceFrom(),projectFilter.getPriceTo(),projectFilter.getAreas(),projectFilter.getSizeFrom(),projectFilter.getSizeTo());
    }
}
