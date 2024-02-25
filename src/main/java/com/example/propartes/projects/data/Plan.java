package com.example.propartes.projects.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plan {

    private Object image;
    private String name;
    private String location;
    private ShortDescription description;
    private Double price_from;
    private Double pricem2;
    private PlanInfo planInfo;

}
