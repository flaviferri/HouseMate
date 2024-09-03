package com.houseMate.houseMate.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="flat")
public class Flat {

    public int id;
    public String name;
    public int number;
    public int rooms;


    public Flat(){}
    public Flat ( int id, String name, int number, int rooms){

        this.id=id;
        this.name=name;
        this.number=number;
        this.rooms=rooms;
    }
}
