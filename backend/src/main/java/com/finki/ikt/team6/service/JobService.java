package com.finki.ikt.team6.service;

import com.finki.ikt.team6.model.Job;
import com.finki.ikt.team6.model.dto.job.JobCreateDTO;
import com.finki.ikt.team6.model.dto.job.JobEditDTO;

import java.util.List;

public interface JobService {
    List<Job> listAll();
    Job findById(Long id);
    Job create(JobCreateDTO jobCreateDTO);
    Job update(Long id, JobEditDTO jobEditDTO);
    Job delete(Long id);
}
