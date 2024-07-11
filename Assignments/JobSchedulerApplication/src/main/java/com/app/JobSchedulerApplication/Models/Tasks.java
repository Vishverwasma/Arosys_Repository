package com.app.JobSchedulerApplication.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TaskId;
    private int JobId;
    private int TaskSeqId;
    private int DependentOnTaskSeqId;
    private String TaskStatus;
	public Tasks() {
		super();
	}
	public Tasks(int TaskId, int JobId, int TaskSeqId, int DependentOnTaskSeqId, String TaskStatus) {
		super();
		this.TaskId = TaskId;
		this.JobId = JobId;
		this.TaskSeqId = TaskSeqId;
		this.DependentOnTaskSeqId = DependentOnTaskSeqId;
		this.TaskStatus = TaskStatus;
	}
	public int getTaskId() {
		return TaskId;
	}
	public void setTaskId(int TaskId) {
		this.TaskId = TaskId;
	}
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int JobId) {
		this.JobId = JobId;
	}
	public int getTaskSeqId() {
		return TaskSeqId;
	}
	public void setTaskSeqId(int TaskSeqId) {
		this.TaskSeqId = TaskSeqId;
	}
	public int getDependentOnTaskSeqId() {
		return DependentOnTaskSeqId;
	}
	public void setDependentOnTaskSeqId(int DependentOnTaskSeqId) {
		this.DependentOnTaskSeqId = DependentOnTaskSeqId;
	}
	public String getTaskStatus() {
		return TaskStatus;
	}
	public void setTaskStatus(String TaskStatus) {
		this.TaskStatus = TaskStatus;
	}
    
    
}
