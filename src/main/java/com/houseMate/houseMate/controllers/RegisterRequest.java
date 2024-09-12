package com.houseMate.houseMate.controllers;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;

@Data
@Builder
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



}
