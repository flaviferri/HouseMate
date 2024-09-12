package com.houseMate.houseMate.controllers;

import com.houseMate.houseMate.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.ObjectError;



import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService AuthService;


  @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
      try {
          AuthResponse response = AuthService.login(request);
          return ResponseEntity.ok(response);
      } catch (Exception e) {
          return ResponseEntity.notFound().build();
      }


  }
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){

        return ResponseEntity.ok(AuthService.register(request));
    }

}
