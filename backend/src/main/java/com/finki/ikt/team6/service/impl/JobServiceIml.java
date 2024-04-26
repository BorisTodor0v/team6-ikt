package com.finki.ikt.team6.service.impl;

import com.finki.ikt.team6.model.Category;
import com.finki.ikt.team6.model.Job;
import com.finki.ikt.team6.model.User;
import com.finki.ikt.team6.model.dto.job.JobCreateDTO;
import com.finki.ikt.team6.model.dto.job.JobEditDTO;
import com.finki.ikt.team6.model.exceptions.InvalidJobIdException;
import com.finki.ikt.team6.repository.JobRepository;
import com.finki.ikt.team6.service.CategoryService;
import com.finki.ikt.team6.service.JobService;
import com.finki.ikt.team6.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceIml implements JobService {

    private final JobRepository jobRepository;
    private final CategoryService categoryService;
    private final UserService userService;

    public JobServiceIml(JobRepository jobRepository, CategoryService categoryService, UserService userService) {
        this.jobRepository = jobRepository;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public List<Job> listAll() {
        return jobRepository.findAll();
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElseThrow(InvalidJobIdException::new);
    }

    @Override
    public Job create(JobCreateDTO jobCreateDTO) {
        List<Long> DTOCategories = jobCreateDTO.getCategories();
        List<Category> categories = new ArrayList<>();
        for (Long id : DTOCategories) {
            Category category = categoryService.findById(id);
            categories.add(category);
        }
        User postedBy = userService.getUserByUsername(jobCreateDTO.getPostedBy());

        Job job = new Job();
        //TODO: Add checks if parameters are valid
        job.setTitle(jobCreateDTO.getTitle());
        job.setDescription(jobCreateDTO.getDescription());
        job.setSalary(jobCreateDTO.getSalary());
        job.setLocation(jobCreateDTO.getLocation());
        job.setExperienceRequired(jobCreateDTO.getExperienceRequired());
        job.setCategories(categories);
        job.setPostedBy(postedBy);

        return jobRepository.save(job);
    }

    @Override
    public Job update(Long id, JobEditDTO jobEditDTO){
        Job job = findById(id);
        List<Long> DTOCategories = jobEditDTO.getCategories();
        List<Category> categories = new ArrayList<>();
        for (Long categoryId : DTOCategories) {
            Category category = categoryService.findById(categoryId);
            categories.add(category);
        }
        //TODO: Add checks if parameters are valid
        job.setTitle(jobEditDTO.getTitle());
        job.setDescription(jobEditDTO.getDescription());
        job.setSalary(jobEditDTO.getSalary());
        job.setLocation(jobEditDTO.getLocation());
        job.setExperienceRequired(jobEditDTO.getExperienceRequired());
        job.setCategories(categories);

        return jobRepository.save(job);
    }

    @Override
    public Job delete(Long id) {
        Job job = findById(id);
        jobRepository.deleteById(id);
        return job;
    }
}
