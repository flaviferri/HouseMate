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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;
    public String name;
    public String lastName;
    public String email;
    public String password;
    public LocalDate birth_day;
    public LocalDate entry_date;
    public LocalDate departure_date;

    public User(){}
    public User(int id , String name, String lastName, String email, String password, LocalDate birth_day, LocalDate entry_date, LocalDate departure_date){

        this.id = id;
        this.name= name;
        this.lastName= lastName;
        this.email=email;
        this.password= password;
        this.birth_day= birth_day;
        this.entry_date= entry_date;
        this.departure_date=departure_date;

    }

}
