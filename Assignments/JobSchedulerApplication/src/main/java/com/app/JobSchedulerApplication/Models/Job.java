package com.app.JobSchedulerApplication.Models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int JobId;
	private int ClientId;
	private String FlowName;
	private String Priority;
	private String JobStatus;
	private LocalDateTime CreatedAt;
	public Job() {
		super();
	}
	public Job(int JobId, int ClientId, String FlowName, String Priority, String JobStatus,
			LocalDateTime CreatedAt) {
		super();
		this.JobId = JobId;
		this.ClientId = ClientId;
		this.FlowName = FlowName;
		this.Priority = Priority;
		this.JobStatus = JobStatus;
		this.CreatedAt = CreatedAt;
	}
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int JobId) {
		this.JobId = JobId;
	}
	public int getClientId() {
		return ClientId;
	}
	public void setClientId(int ClientId) {
		this.ClientId = ClientId;
	}
	public String getFlowName() {
		return FlowName;
	}
	public void setFlowName(String FlowName) {
		FlowName = FlowName;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String Priority) {
		this.Priority = Priority;
	}
	public String getJobStatus() {
		return JobStatus;
	}
	public void setJobStatus(String JobStatus) {
		this.JobStatus = JobStatus;
	}
	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(LocalDateTime CreatedAt) {
		this.CreatedAt = CreatedAt;
	}
	
}
