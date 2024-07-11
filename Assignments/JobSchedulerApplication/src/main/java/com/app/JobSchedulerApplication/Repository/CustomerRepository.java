package com.app.JobSchedulerApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.JobSchedulerApplication.Models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByActiveTrue();
}

