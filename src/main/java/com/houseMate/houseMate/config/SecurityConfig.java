package com.houseMate.houseMate.config;

import com.houseMate.houseMate.jwt.JwtAuthenticacionFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.houseMate.houseMate.role.Permission.*;
import static com.houseMate.houseMate.role.Role.ADMIN;
import static com.houseMate.houseMate.role.Role.USER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticacionFilter jwtAuthenticacionFilter;
    private final AuthenticationProvider authenticationProvider;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       return http
               .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/auth/**").permitAll()

                                .requestMatchers("/management/**").hasAnyRole(ADMIN.name(), USER.name())
                                .requestMatchers(HttpMethod.GET,"/management/**").hasAnyAuthority(ADMIN_READ.name(),USER_GET.name())
                                .requestMatchers(HttpMethod.POST,"/management/**").hasAnyAuthority(ADMIN_CREATED.name(),USER_CREATED.name())
                                .requestMatchers(HttpMethod.DELETE,"/management/**").hasAnyAuthority(ADMIN_DELETE.name(),USER_DELETE.name())
                                .requestMatchers(HttpMethod.PUT,"/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),USER_UPDATE.name())
                                .requestMatchers("/management/**").hasRole(ADMIN.name())


                                .requestMatchers("/admin/**").hasAnyRole(ADMIN.name())
                                .requestMatchers(HttpMethod.GET,"/admin/**").hasAuthority(ADMIN_READ.name())
                                .requestMatchers(HttpMethod.POST,"/admin/**").hasAuthority(ADMIN_CREATED.name())
                                .requestMatchers(HttpMethod.DELETE,"/admin/**").hasAuthority(ADMIN_DELETE.name())
                                .requestMatchers(HttpMethod.PUT,"/admin/**").hasAuthority(ADMIN_UPDATE.name())

                                .anyRequest().authenticated()
                )
               .sessionManagement(sessionManager ->
                       sessionManager
                               .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
               )
               .authenticationProvider(authenticationProvider)
               .addFilterBefore(jwtAuthenticacionFilter, UsernamePasswordAuthenticationFilter.class)
               .build();


    }
}
