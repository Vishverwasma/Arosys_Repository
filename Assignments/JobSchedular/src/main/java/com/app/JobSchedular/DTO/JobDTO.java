package com.app.JobSchedular.DTO;

import java.time.LocalDateTime;

public class JobDTO {
    private Long jobId;
    private String flowName;
    private String priority;
    private String jobStatus;
    private LocalDateTime createdAt;
    private Long clientId;

    // Constructors
    public JobDTO() {}

    public JobDTO(Long jobId, String flowName, String priority, String jobStatus, LocalDateTime createdAt, Long clientId) {
        this.jobId = jobId;
        this.flowName = flowName;
        this.priority = priority;
        this.jobStatus = jobStatus;
        this.createdAt = createdAt;
        this.clientId = clientId;
    }

    // Getters and Setters
    
	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
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

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

    
}

