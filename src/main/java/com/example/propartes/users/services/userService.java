package com.example.propartes.users.services;

import com.example.propartes.security.TokenServices;
import com.example.propartes.users.data.DTO.loginDTO;
import com.example.propartes.users.data.DTO.loginResponseDTO;
import com.example.propartes.users.data.DTO.loginStatus;
import com.example.propartes.users.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class userService {

    @Autowired
    private userRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenServices tokenServices;
    public loginResponseDTO loginUser(loginDTO loginDTO){
        User login_user = userRepo.findByEmail(loginDTO.getEmail());
        if(login_user!=null){
            if(passwordEncoder.matches(loginDTO.getPassword(),login_user.getPassword())){
                return new loginResponseDTO(tokenServices.generateTokenUser(login_user), loginStatus.OK);
            }
            else {
                return new loginResponseDTO("",loginStatus.FAILED);
            }
        }
        return new loginResponseDTO("", loginStatus.FAILED);
    }

    public void createUser(loginDTO user){
        User user1 = new User(user.getEmail(),passwordEncoder.encode(user.getPassword()));
        userRepo.save(user1);
    }
}
