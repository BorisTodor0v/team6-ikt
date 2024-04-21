package com.finki.ikt.team6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Job {

    @Id
    private Long id;
    private String title;
    private String description;
    private double salary;
    private String location;
    private int experienceRequired;

    public Job() {}

    public Job(String title, String description, double salary, String location, int experienceRequired, List<Category> categories) {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.location = location;
        this.experienceRequired = experienceRequired;
        this.categories = categories;
    }

    @ManyToMany
    private List<Category> categories;

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(int experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

