package com.houseMate.houseMate.services;

import ch.qos.logback.classic.Logger;
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

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private Logger logger;


    public AuthResponse login(LoginRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .user(user)
                .build();

    }


    public AuthResponse register(RegisterRequest request) {
        try {
            Optional<User> existingUser = userRepository.findByEmail(request.getEmail());
            if (existingUser.isPresent()) {
                throw new IllegalStateException("The email is already used");
            }

            User user = User.builder()
                    .name(request.getName())
                    .lastName(request.getLastname())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .birth_day(request.getBirth_day())
                    .departure_date(request.getDeparture_date())
                    .role(request.getRole())
                    .build();
            userRepository.save(user);

            return AuthResponse.builder()
                    .token(jwtService.getToken(user))
                    .user(user)
                    .build();
        } catch (Exception exception) {
            logger.error("Error occurred during user registration", exception);
            throw new RuntimeException("An error occurred while registering the user", exception);
        }
    }
}