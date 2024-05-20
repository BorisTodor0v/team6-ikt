package com.finki.ikt.team6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double salary;
    private String location;
    private int experienceRequired;
    @ManyToOne
    @JoinColumn(name = "posted_by_id")
    private User postedBy;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;
}

