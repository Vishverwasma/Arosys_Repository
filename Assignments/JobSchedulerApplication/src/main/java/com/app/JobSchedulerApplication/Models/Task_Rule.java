package com.app.JobSchedulerApplication.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "db_Task_Rule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task_Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ClientType;
	private int TaskSeqId;
	private int DependendOnTaskSeqId;
	private String TaskStatus;
	public Task_Rule() {
		super();
	}
	public Task_Rule(int id, String clientType, int taskSeqId, int dependendOnTaskSeqId, String taskStatus) {
		super();
		this.id = id;
		ClientType = clientType;
		TaskSeqId = taskSeqId;
		DependendOnTaskSeqId = dependendOnTaskSeqId;
		TaskStatus = taskStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientType() {
		return ClientType;
	}
	public void setClientType(String clientType) {
		ClientType = clientType;
	}
	public int getTaskSeqId() {
		return TaskSeqId;
	}
	public void setTaskSeqId(int taskSeqId) {
		TaskSeqId = taskSeqId;
	}
	public int getDependendOnTaskSeqId() {
		return DependendOnTaskSeqId;
	}
	public void setDependendOnTaskSeqId(int dependendOnTaskSeqId) {
		DependendOnTaskSeqId = dependendOnTaskSeqId;
	}
	public String getTaskStatus() {
		return TaskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		TaskStatus = taskStatus;
	}
	
}
