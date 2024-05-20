package com.finki.ikt.team6.model.dto.job;

import lombok.Data;

import java.util.List;

@Data
public class JobCreateDTO {
    private String title;
    private String description;
    private double salary;
    private String location;
    private int experienceRequired;
    private List<Long> categories;
    private String postedBy;

    public static JobCreateDTO of(String title, String description, Double salary, String location, int experienceRequired, List<Long> categories, String postedBy){
        JobCreateDTO jobCreateDTO = new JobCreateDTO();
        jobCreateDTO.title = title;
        jobCreateDTO.description = description;
        jobCreateDTO.salary = salary;
        jobCreateDTO.location = location;
        jobCreateDTO.experienceRequired = experienceRequired;
        jobCreateDTO.categories = categories;
        jobCreateDTO.postedBy = postedBy;
        return jobCreateDTO;
    }
}
