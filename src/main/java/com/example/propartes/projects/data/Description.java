package com.example.propartes.projects.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {
    private int total_floors;
    private String type;
    private String floor;
    private Double area;
    private int rooms;
}
