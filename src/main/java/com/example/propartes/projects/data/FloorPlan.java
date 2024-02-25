package com.example.propartes.projects.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FloorPlan {

    private Double price_from;
    private List<Plan> plans;
}
