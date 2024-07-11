package com.app.JobSchedulerApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.JobSchedulerApplication.Models.Job;
import com.app.JobSchedulerApplication.Repository.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable int id) {
        return jobRepository.findById(id)
                .map(job -> ResponseEntity.ok().body(job))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable int id, @RequestBody Job jobDetails) {
        return jobRepository.findById(id)
                .map(job -> {
                    job.setFlowName(jobDetails.getFlowName());
                    job.setPriority(jobDetails.getPriority());
                    job.setJobStatus(jobDetails.getJobStatus());
                    job.setCreatedAt(jobDetails.getCreatedAt());
                    Job updatedJob = jobRepository.save(job);
                    return ResponseEntity.ok().body(updatedJob);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable int id) {
        return jobRepository.findById(id)
                .map(job -> {
                    jobRepository.delete(job);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
