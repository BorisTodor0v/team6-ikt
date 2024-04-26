package com.finki.ikt.team6.model.dto.job;

import lombok.Data;

import java.util.List;

@Data
public class JobEditDTO {
    private String title;
    private String description;
    private double salary;
    private String location;
    private int experienceRequired;
    private List<Long> categories;

    public static JobEditDTO of(String title, String description, Double salary, String location, int experienceRequired, List<Long> categories){
        JobEditDTO jobEditDTO = new JobEditDTO();
        jobEditDTO.title = title;
        jobEditDTO.description = description;
        jobEditDTO.salary = salary;
        jobEditDTO.location = location;
        jobEditDTO.experienceRequired = experienceRequired;
        jobEditDTO.categories = categories;
        return jobEditDTO;
    }
}
