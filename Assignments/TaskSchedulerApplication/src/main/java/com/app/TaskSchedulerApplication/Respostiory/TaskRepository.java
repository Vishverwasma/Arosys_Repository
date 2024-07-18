package com.app.TaskSchedulerApplication.Respostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.TaskSchedulerApplication.Models.Task;
import com.app.TaskSchedulerApplication.Models.Job;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByJobId(Long jobId);
    List<Task> findByJob(Job job); 
}
