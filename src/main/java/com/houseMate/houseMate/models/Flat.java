package com.houseMate.houseMate.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name="flat")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String street;
    public int number;
    public int floor;
    public int postCode;
    public int rooms;


    public Flat(){}

}
