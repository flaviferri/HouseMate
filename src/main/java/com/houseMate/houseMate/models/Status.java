package com.houseMate.houseMate.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
    @Table(name = "status")
    public class Status {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String description;

    public Status(String description) {
        this.description = description;
    }
}
