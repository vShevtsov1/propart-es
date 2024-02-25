package com.example.propartes.projects.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanInfo {
    private String room_name;
    private String condition;
    private String type;
    private String name;
    private String woodwork;
    private Integer floor;
    private String heatingType;
    private String hotWater;
    private Integer bedrooms;
    private Integer bathrooms;
    private Integer toilets;
    private Boolean terrace;
    private String kitchen;
    private Double buildedSurface;
    private Double usefulSurface;
    private Double terraceSurface;

}
