package com.app.JobSchedular.Controllers;

import com.app.JobSchedular.Models.Customer;
import com.app.JobSchedular.Models.Job;
import com.app.JobSchedular.Repository.CustomerRepository;
import com.app.JobSchedular.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private JobRepository jobRepository;

    @GetMapping("/all")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Customer customer = customerRepository.findById(job.getCustomer().getId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        job.setCustomer(customer);
        Job savedJob = jobRepository.save(job);
        return ResponseEntity.ok(savedJob);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Long id, @RequestBody Job jobDetails) {
    	Optional<Job> optionalJob = jobRepository.findById(id);

        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();
            existingJob.setFlowName(jobDetails.getFlowName());
            existingJob.setPriority(jobDetails.getPriority());
            existingJob.setJobStatus(jobDetails.getJobStatus());
            existingJob.setCreatedAt(jobDetails.getCreatedAt());
            existingJob.setCustomer(jobDetails.getCustomer());

            Job updatedJob = jobRepository.save(existingJob);
            return ResponseEntity.ok(updatedJob);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
    	if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
