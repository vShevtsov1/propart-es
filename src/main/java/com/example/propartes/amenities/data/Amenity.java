package com.example.propartes.amenities.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "amenity")
public class Amenity {

    private String _id;
    private String image_code;
    private String name;


}
