package com.houseMate.houseMate.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity

@Table(name="flat")
public class Flat extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public String street;
    public int number;
    public int floor;
    public int postCode;
    public int rooms;
    @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks = new ArrayList<>();



    public Flat(){}

}
