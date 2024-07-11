package com.app.JobSchedular.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.JobSchedular.Models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByActiveTrue();
}
