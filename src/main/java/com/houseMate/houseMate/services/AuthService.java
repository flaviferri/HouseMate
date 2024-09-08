package com.houseMate.houseMate.services;

import com.houseMate.houseMate.controllers.AuthResponse;
import com.houseMate.houseMate.controllers.LoginRequest;
import com.houseMate.houseMate.controllers.RegisterRequest;
import com.houseMate.houseMate.models.User;
import com.houseMate.houseMate.repositories.UserRepository;
import com.houseMate.houseMate.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest request) {
      authenticationManager
              .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .user(user)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
      User user = User.builder()
                .name(request.getName())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .birth_day(request.getBirth_day())
                .departure_date(request.getDeparture_date())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .user(user)
                .build();
    }
}
