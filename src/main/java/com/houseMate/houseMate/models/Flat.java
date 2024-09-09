package com.houseMate.houseMate.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
 /*   @OneToMany(mappedBy = "flat", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)

    private List<Task> tasks = new ArrayList<>();*/
 @ManyToOne(fetch = FetchType.EAGER)
 @JoinColumn(name = "user_id") // Asegúrate de que esta columna no permita valores nulos
 private User user;

/*    @OneToMany
    @JoinColumn(name = "user_id", nullable = false)
    private List<User> users = new ArrayList<>();*/



    public Flat(){}

}
