package com.houseMate.houseMate.models;


import jakarta.persistence.*;

@Entity
    @Table(name = "status")
    public class Status {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String description;

    }
