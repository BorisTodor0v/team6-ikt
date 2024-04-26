package com.finki.ikt.team6.controller.rest;

import com.finki.ikt.team6.model.Job;
import com.finki.ikt.team6.model.dto.job.JobCreateDTO;
import com.finki.ikt.team6.model.dto.job.JobDetailsDTO;
import com.finki.ikt.team6.model.dto.job.JobEditDTO;
import com.finki.ikt.team6.model.exceptions.InvalidCategoryIdException;
import com.finki.ikt.team6.model.exceptions.InvalidJobIdException;
import com.finki.ikt.team6.model.exceptions.UsernameDoesNotExistException;
import com.finki.ikt.team6.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/jobs")
public class JobsRestController {
    private final JobService jobService;

    public JobsRestController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> listAllJobs(){
        return this.jobService.listAll();
    }

    /**
     * @param id
     * @return DTO of the returned Job which includes a DTO of the user who posted the job
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        try{
            JobDetailsDTO job = JobDetailsDTO.of(this.jobService.findById(id));
            return new ResponseEntity<>(job, HttpStatus.FOUND);
        } catch (InvalidJobIdException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody JobCreateDTO jobCreateDTO){
        try{
            JobDetailsDTO job = JobDetailsDTO.of(this.jobService.create(jobCreateDTO));
            return new ResponseEntity<>(job, HttpStatus.CREATED);
        } catch (InvalidCategoryIdException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (UsernameDoesNotExistException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody JobEditDTO jobEditDTO){
        try{
            JobDetailsDTO job = JobDetailsDTO.of(this.jobService.update(id, jobEditDTO));
            return new ResponseEntity<>(job, HttpStatus.OK);
        } catch (InvalidJobIdException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (UsernameDoesNotExistException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (InvalidCategoryIdException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            JobDetailsDTO job = JobDetailsDTO.of(this.jobService.delete(id));
            return new ResponseEntity<>(job, HttpStatus.OK);
        } catch (InvalidJobIdException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }
}
