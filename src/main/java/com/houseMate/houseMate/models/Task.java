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
    public LocalDate deadline_date;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "flat_id")
    private Flat flat;







    public Task() {

    }


}



