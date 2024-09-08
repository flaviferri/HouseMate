package com.houseMate.houseMate.controllers;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    public String name;
    public String lastname;
    public String email;
    public String password;
    public LocalDate birth_day;
    public LocalDate departure_date;



}
