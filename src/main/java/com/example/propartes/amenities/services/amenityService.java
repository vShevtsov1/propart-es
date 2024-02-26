package com.example.propartes.amenities.services;

import com.example.propartes.amenities.data.Amenity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class amenityService {

    @Autowired
    private amenityRepo amenityRepo;


    public void createAmenity(Amenity amenity){
        amenityRepo.save(amenity);
    }

    public List<Amenity> getAmenityById(List<String> id){
        return amenityRepo.findAllBy_idIn(id);
    }
}
