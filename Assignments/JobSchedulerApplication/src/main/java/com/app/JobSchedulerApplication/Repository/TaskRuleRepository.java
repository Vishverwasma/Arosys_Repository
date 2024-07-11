package com.app.JobSchedulerApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.JobSchedulerApplication.Models.*;

public interface TaskRuleRepository extends JpaRepository<Task_Rule, Integer> {
}

