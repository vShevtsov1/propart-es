package com.example.propartes.projects.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "project")
public class Project {

    private String _id;
    private String name;
    private String completion;
    private Double size;
    private Boolean hidden;
    private Double price_from;
    private Double size_m2;
    private String location;
    private Description short_description;
    private List<Object> pictures;
    private Location coordinates;
    private String area;
    private Map<String,About> about;
    private List<String> amenities;
    private Map<String,FloorPlan> floorPlans;

    public Project(String name, String completion, Double size, Boolean hidden, Double price_from, Double size_m2, String location, Description short_description, List<Object> pictures, Location coordinates, String area, Map<String, About> about, List<String> amenities, Map<String, FloorPlan> floorPlans) {
        this.name = name;
        this.completion = completion;
        this.size = size;
        this.hidden = hidden;
        this.price_from = price_from;
        this.size_m2 = size_m2;
        this.location = location;
        this.short_description = short_description;
        this.pictures = pictures;
        this.coordinates = coordinates;
        this.area = area;
        this.about = about;
        this.amenities = amenities;
        this.floorPlans = floorPlans;
    }
}
