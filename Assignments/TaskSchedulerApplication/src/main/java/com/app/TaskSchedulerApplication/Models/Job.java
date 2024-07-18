package com.app.TaskSchedulerApplication.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "db_jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientId")
    private Customer customer;

    @Column(name = "flow_name")
    private String flowName;

    @Column(name = "priority")
    private String priority;

    @Column(name = "job_status")
    private String jobStatus;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
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
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Job() {
		super();
	}
	public Job(Long id, Customer customer, String flowName, String priority, String jobStatus,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.customer = customer;
		this.flowName = flowName;
		this.priority = priority;
		this.jobStatus = jobStatus;
		this.createdAt = createdAt;
	}

}
