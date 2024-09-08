package com.houseMate.houseMate.controllers;

import com.houseMate.houseMate.services.AuthService;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService AuthService;


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        try{
            AuthResponse response = AuthService.login(request);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(AuthService.register(request));
    }

}
