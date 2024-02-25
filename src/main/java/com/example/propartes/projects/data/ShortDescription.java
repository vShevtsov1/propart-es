package com.example.propartes.projects.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShortDescription {

    private Integer totalFloors;
    private String type;
    private Integer floor;
    private Double area;

}
