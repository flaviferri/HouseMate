package com.houseMate.houseMate.models;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;


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
    public LocalDate entry_date;
    public LocalDate deadline_date;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_status")
    private Status status;


}



