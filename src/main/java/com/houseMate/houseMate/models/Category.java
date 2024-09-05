package com.houseMate.houseMate.models;

import jakarta.persistence.*;


@Entity
@Table(name = "category")
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;

    }





