package com.app.TaskSchedulerApplication.Respostiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.TaskSchedulerApplication.Models.TaskRule;

public interface TaskRuleRepository extends JpaRepository<TaskRule, Long> {
}

