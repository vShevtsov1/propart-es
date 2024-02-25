package com.example.propartes.users.services;

import com.example.propartes.users.data.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userRepo extends MongoRepository<User,String> {

    User findByEmail(String email);
}
