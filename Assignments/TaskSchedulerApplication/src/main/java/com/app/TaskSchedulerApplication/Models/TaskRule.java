package com.app.TaskSchedulerApplication.Models;

import jakarta.persistence.*;

@Entity
public class TaskRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientType;
    private int taskSeqId;
    private String dependentOnTaskSeqId;
    private String taskStatus;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public int getTaskSeqId() {
		return taskSeqId;
	}
	public void setTaskSeqId(int taskSeqId) {
		this.taskSeqId = taskSeqId;
	}
	public String getDependentOnTaskSeqId() {
		return dependentOnTaskSeqId;
	}
	public void setDependentOnTaskSeqId(String dependentOnTaskSeqId) {
		this.dependentOnTaskSeqId = dependentOnTaskSeqId;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public TaskRule() {
		super();
	}
	public TaskRule(Long id, String clientType, int taskSeqId, String dependentOnTaskSeqId, String taskStatus) {
		super();
		this.id = id;
		this.clientType = clientType;
		this.taskSeqId = taskSeqId;
		this.dependentOnTaskSeqId = dependentOnTaskSeqId;
		this.taskStatus = taskStatus;
	}

}
