package com.app.TaskSchedulerApplication.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "db_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "task_seq_id")
    private Integer taskSeqId;

    @Column(name = "dependent_on_task_seq_id")
    private String dependentOnTaskSeqId;

    @Column(name = "task_status")
    private String taskStatus;


	public Task() {}

	public Task(Long id, Job job, int taskSeqId, String dependentOnTaskSeqId, String taskStatus) {
		super();
		this.id = id;
		this.job = job;
		this.taskSeqId = taskSeqId;
		this.dependentOnTaskSeqId = dependentOnTaskSeqId;
		this.taskStatus = taskStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
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
	

}
