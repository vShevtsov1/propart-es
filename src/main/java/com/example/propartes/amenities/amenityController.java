package com.example.propartes.amenities;

import com.example.propartes.amenities.data.Amenity;
import com.example.propartes.amenities.services.amenityService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/amenity")
public class amenityController {

    @Autowired
    private amenityService amenityService;


    @GetMapping("/id")
    public List<Amenity> getAmenitiesByIds(@RequestBody List<String> amenities){
        return amenityService.getAmenityById(amenities);
    }

    @PostMapping("/create")
    public void createAmenity(@RequestBody Amenity amenity){
        amenityService.createAmenity(amenity);
    }

    @GetMapping("/")
    public List<Amenity> getAll(){return amenityService.getAll();}

}
