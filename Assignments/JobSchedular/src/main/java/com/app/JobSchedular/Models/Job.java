package com.app.JobSchedular.Models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "db_jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private Customer customer;
//    private Long clientId;
    private String flowName;
    private String priority;
    private String jobStatus;
    private LocalDateTime createdAt;

    //Constructors
	public Job(Long jobId, Customer customer, String flowName, String priority, String jobStatus, LocalDateTime createdAt) {
		super();
		this.jobId = jobId;
		this.customer = customer;
		this.flowName = flowName;
		this.priority = priority;
		this.jobStatus = jobStatus;
		this.createdAt = createdAt;
	}
	public Job() {
		super();
	}
    
    
    // Getters and setters
    public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Customer getClientId() {
		return customer;
	}
	public void setClientId(Customer customer) {
		this.customer = customer;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime now) {
		this.createdAt = now;
	}
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return customer;
	}
	public void setCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.customer = customer;
	}

}

