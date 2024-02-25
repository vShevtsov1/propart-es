package com.example.propartes.projects.DTO;

import com.example.propartes.projects.data.About;
import com.example.propartes.projects.data.Description;
import com.example.propartes.projects.data.FloorPlan;
import com.example.propartes.projects.data.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private String name;
    private Double price_from;
    private Boolean hidden;
    private String completion;
    private Double size;

    private Double size_m2;
    private String location;
    private Description short_description;
    private List<Object> pictures;
    private Location coordinates;
    private String area;
    private Map<String,About> about;
    private List<String> amenities;
    private Map<String, FloorPlan> floorPlans;
}
