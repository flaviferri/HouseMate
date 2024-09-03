package com.houseMate.houseMate.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Setter
@Getter
@Entity
@Table(name="tasks")
public class Task extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String title;
    private String description;
    private int category;
    private int status;





}
