package com.example.propartes.users;

import com.example.propartes.users.data.DTO.loginDTO;
import com.example.propartes.users.data.DTO.loginResponseDTO;
import com.example.propartes.users.services.userRepo;
import com.example.propartes.users.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userRepo;

    @PostMapping("/login")
    public loginResponseDTO loginUser(@RequestBody loginDTO loginDTO){
        return userRepo.loginUser(loginDTO);
    }
}
