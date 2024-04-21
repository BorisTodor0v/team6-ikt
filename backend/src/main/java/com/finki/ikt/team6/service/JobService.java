package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Job;

import java.util.List;

public interface JobService {
    List<Job> listAllProducts();
    Job findById(Long id);
    Job create(String title, String description, Double salary,String location,int experienceRequired, List<Long> categories);
    Job update(Long id,String title, String description, Double salary,String location,int experienceRequired, List<Long> categories);

    Job delete(Long id);
}
