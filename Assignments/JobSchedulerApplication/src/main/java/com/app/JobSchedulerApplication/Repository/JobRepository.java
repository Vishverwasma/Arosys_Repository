package com.app.JobSchedulerApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.JobSchedulerApplication.Models.*;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
