package com.yusuf.pathForgeBackend.service;

import com.yusuf.pathForgeBackend.entity.UserDetail;
import com.yusuf.pathForgeBackend.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserDetailRepository userRepo;

    public AuthService(UserDetailRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(UserDetail userDetail)
    {
        if(userRepo.findByUsername(userDetail.getUsername()).isPresent()){
            throw new RuntimeException("Username already exists");
        }
        if(userRepo.findByEmail(userDetail.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }
        userRepo.save(userDetail);
    }
}
