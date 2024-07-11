package com.app.JobSchedulerApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.JobSchedulerApplication.Models.Customer;
import com.app.JobSchedulerApplication.Repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        return customerRepository.findById(id)
                .map(customer -> ResponseEntity.ok().body(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    	Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok().body(savedCustomer);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(customerDetails.getName());
                    customer.setClientType(customerDetails.getClientType());
                    customer.setActive(customerDetails.getActive());
                    customer.setNextRunTs(customerDetails.getNextRunTs());
                    Customer updatedCustomer = customerRepository.save(customer);
                    return ResponseEntity.ok().body(updatedCustomer);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customerRepository.delete(customer);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
