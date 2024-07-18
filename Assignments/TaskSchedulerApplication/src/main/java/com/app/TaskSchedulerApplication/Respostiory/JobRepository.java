package com.app.TaskSchedulerApplication.Respostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.TaskSchedulerApplication.Models.Job;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByJobStatusIn(List<String> statuses);
}
