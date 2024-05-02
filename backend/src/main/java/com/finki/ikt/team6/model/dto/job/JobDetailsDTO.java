package com.finki.ikt.team6.model.dto.job;

import com.finki.ikt.team6.model.Category;
import com.finki.ikt.team6.model.Job;
import com.finki.ikt.team6.model.dto.user.UserDetailsDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Used a ResponseBody that contains all details of a job posting
 */
@Data
public class JobDetailsDTO {
    private Long id;
    private String title;
    private String description;
    private double salary;
    private String location;
    private int experienceRequired;
    private List<Category> categories;
    private UserDetailsDTO postedBy;

    public static JobDetailsDTO of(Job job){
        JobDetailsDTO jobDetailsDTO = new JobDetailsDTO();
        jobDetailsDTO.setId(job.getId());
        jobDetailsDTO.setTitle(job.getTitle());
        jobDetailsDTO.setDescription(job.getDescription());
        jobDetailsDTO.setSalary(job.getSalary());
        jobDetailsDTO.setLocation(job.getLocation());
        jobDetailsDTO.setExperienceRequired(job.getExperienceRequired());
        jobDetailsDTO.setCategories(job.getCategories());
        jobDetailsDTO.setPostedBy(UserDetailsDTO.of(job.getPostedBy()));
        return jobDetailsDTO;
    }

    public static List<JobDetailsDTO> of(List<Job> jobs){
        List<JobDetailsDTO> jobDetailsDTOS = new ArrayList<>();
        for (Job job: jobs) {
            jobDetailsDTOS.add(JobDetailsDTO.of(job));
        }
        return jobDetailsDTOS;
    }

}
