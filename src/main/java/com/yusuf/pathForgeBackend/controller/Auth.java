package com.yusuf.pathForgeBackend.controller;

import com.yusuf.pathForgeBackend.entity.UserDetail;
import com.yusuf.pathForgeBackend.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class Auth {
    private final AuthService authService;
    public Auth(AuthService authService){
        this.authService = authService;
    }
    @PostMapping("/register")
    public String register(@RequestBody UserDetail userDetail){
        try {
            authService.registerUser(userDetail);
            return "Successfull";
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }



}
