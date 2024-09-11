package com.houseMate.houseMate.controllers;


import com.houseMate.houseMate.role.Role;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Data
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:4001")
public class RegisterRequest {

    public String name;
    public String lastname;
    public String email;
    public String password;
    public LocalDate birth_day;
    public LocalDate departure_date;
    private Role role;



}
