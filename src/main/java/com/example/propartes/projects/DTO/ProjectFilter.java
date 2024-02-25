package com.example.propartes.projects.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectFilter {
    private  List<String> bedrooms;
    private List<String> completion;
    private String location;
    private List<String> type;
    private Double priceFrom;
    private Double priceTo;
    private List<String> areas;
    private Double sizeFrom;
    private Double sizeTo;
}
