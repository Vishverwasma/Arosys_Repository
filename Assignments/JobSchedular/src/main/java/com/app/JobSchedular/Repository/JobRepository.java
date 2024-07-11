package com.app.JobSchedular.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.JobSchedular.Models.Customer;
import com.app.JobSchedular.Models.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCustomerAndJobStatusIn(Customer customer, List<String> jobStatus);
}

