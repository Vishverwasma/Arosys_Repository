package com.app.JobSchedular.ServiceAndImplementation;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.JobSchedular.Models.Customer;
import com.app.JobSchedular.Models.Job;
import com.app.JobSchedular.Repository.CustomerRepository;
import com.app.JobSchedular.Repository.JobRepository;

import jakarta.transaction.Transactional;

@Service
public class JobSchedulerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private JobRepository jobRepository;

    @Transactional
    public void scheduleJobs() {
        List<Customer> customers = customerRepository.findByActiveTrue();
        LocalDateTime now = LocalDateTime.now();

        for (Customer customer : customers) {
            LocalDateTime nextRunTs = customer.getNextRunTs();
            if (nextRunTs == null || nextRunTs.isAfter(now)) {
                continue;
            }

            List<Job> previousJobs = jobRepository.findByCustomerAndJobStatusIn(
                    customer, Arrays.asList("Pending", "Processing"));
            if (!previousJobs.isEmpty()) {
                continue;
            }

            Job newJob = new Job();
            newJob.setClientId(customer);
            newJob.setCreatedAt(now);

            switch (customer.getClientType()) {
                case "Enterprise":
                    newJob.setFlowName("Job v1");
                    newJob.setPriority("high");
                    if (nextRunTs.isBefore(now.minus(5, ChronoUnit.MINUTES))) {
                        jobRepository.save(newJob);
                        customer.setNextRunTs(now.plus(5, ChronoUnit.MINUTES));
                    }
                    break;
                case "Standard":
                    newJob.setFlowName("Job v2");
                    newJob.setPriority("regular");
                    if (nextRunTs.isBefore(now.minus(1, ChronoUnit.HOURS))) {
                        jobRepository.save(newJob);
                        customer.setNextRunTs(now.plus(1, ChronoUnit.HOURS));
                    }
                    break;
                case "Free":
                    newJob.setFlowName("Job v3");
                    newJob.setPriority("low");
                    if (nextRunTs.isBefore(now.minus(7, ChronoUnit.DAYS))) {
                        jobRepository.save(newJob);
                        customer.setNextRunTs(now.plus(7, ChronoUnit.DAYS));
                    }
                    break;
            }

            customerRepository.save(customer);
        }
    }
}

