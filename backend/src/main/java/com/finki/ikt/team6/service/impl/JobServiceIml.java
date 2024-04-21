package com.finki.ikt.team6.service.impl;

import com.finki.ikt.team6.model.Category;
import com.finki.ikt.team6.model.Job;
import com.finki.ikt.team6.model.exceptions.InvalidJobIdException;
import com.finki.ikt.team6.repository.CategoryRepository;
import com.finki.ikt.team6.repository.JobRepository;
import com.finki.ikt.team6.service.JobService;

import java.util.List;

public class JobServiceIml implements JobService {

    private final JobRepository jobRepository;
    private final CategoryRepository categoryRepository;

    public JobServiceIml(JobRepository jobRepository, CategoryRepository categoryRepository) {
        this.jobRepository = jobRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Job> listAllProducts() {
        return jobRepository.findAll();
    }

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElseThrow(InvalidJobIdException::new);
    }

    @Override
    public Job create(String title, String description, Double salary, String location, int experienceRequired, List<Long> categories) {
        List<Category> categoryList = categoryRepository.findAllById(categories);
        Job job = new Job(title,description,salary,location,experienceRequired,categoryList);
        return jobRepository.save(job);
    }

    @Override
    public Job update(Long id, String title, String description, Double salary, String location, int experienceRequired, List<Long> categories) {
        Job job = findById(id);
        List<Category> categoryList = categoryRepository.findAllById(categories);

        job.setTitle(title);
        job.setDescription(description);
        job.setSalary(salary);
        job.setLocation(location);
        job.setExperienceRequired(experienceRequired);
        job.setCategories(categoryList);

        return jobRepository.save(job);
    }

    @Override
    public Job delete(Long id) {
        Job job = findById(id);
        jobRepository.deleteById(id);
        return job;
    }
}
