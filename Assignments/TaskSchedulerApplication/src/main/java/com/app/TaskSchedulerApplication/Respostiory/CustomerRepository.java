package com.app.TaskSchedulerApplication.Respostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.TaskSchedulerApplication.Models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

