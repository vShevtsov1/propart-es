package com.example.propartes.amenities.services;

import com.example.propartes.amenities.data.Amenity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface amenityRepo extends MongoRepository<Amenity,String> {

    List<Amenity> findAllBy_idIn(List<String> ids);
}
