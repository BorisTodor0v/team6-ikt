package com.finki.ikt.team6.repository;

import com.finki.ikt.team6.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
