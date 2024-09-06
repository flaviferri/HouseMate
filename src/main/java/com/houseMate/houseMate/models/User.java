package com.houseMate.houseMate.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter @Setter
@Entity
@Table(name="app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String lastName;
    public String email;
    public String password;
    public LocalDate birth_day;
    public LocalDate entry_date;
    public LocalDate departure_date;

    public User(){}


}
