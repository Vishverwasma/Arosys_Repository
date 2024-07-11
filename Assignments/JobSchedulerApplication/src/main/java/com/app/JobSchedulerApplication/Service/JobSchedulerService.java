package com.app.JobSchedulerApplication.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.JobSchedulerApplication.Models.Customer;
import com.app.JobSchedulerApplication.Models.Job;
import com.app.JobSchedulerApplication.Repository.CustomerRepository;
import com.app.JobSchedulerApplication.Repository.JobRepository;

import jakarta.transaction.Transactional;

@Service
public class JobSchedulerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private JobRepository jobRepository;

    @Transactional
    public void scheduleJobs() {
        List<Customer> activeCustomers = customerRepository.findByActiveTrue();

        for (Customer customer : activeCustomers) {
            if (shouldCreateJob(customer)) {
                createJob(customer);
                updateNextRunTs(customer);
            }
        }
    }

    private boolean shouldCreateJob(Customer customer) {
        LocalDateTime nextRunTs = customer.getNextRunTs();
        if (nextRunTs == null || nextRunTs.isAfter(LocalDateTime.now())) {
            return false;
        }

        String jobStatus = "Pending"; // Assuming status should be fetched from somewhere else

        return !jobStatus.equals("Pending") && !jobStatus.equals("Processing");
    }

    private void createJob(Customer customer) {
        Job job = new Job();
        job.setClientId(customer.getId());
        job.setCreatedAt(LocalDateTime.now());

        switch (customer.getClientType()) {
            case "Enterprise":
                job.setFlowName("Job v1");
                job.setPriority("high");
                break;
            case "Standard":
                job.setFlowName("Job v2");
                job.setPriority("regular");
                break;
            case "Free":
                job.setFlowName("Job v3");
                job.setPriority("low");
                break;
        }

        job.setJobStatus("Pending");
        jobRepository.save(job);
    }

    private void updateNextRunTs(Customer customer) {
        LocalDateTime nextRunTs = LocalDateTime.now();

        switch (customer.getClientType()) {
            case "Enterprise":
                nextRunTs = nextRunTs.plusMinutes(5);
                break;
            case "Standard":
                nextRunTs = nextRunTs.plusMinutes(60);
                break;
            case "Free":
                nextRunTs = nextRunTs.plusDays(7);
                break;
        }

        customer.setNextRunTs(nextRunTs);
        customerRepository.save(customer);
    }
}
