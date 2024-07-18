package com.app.TaskSchedulerApplication.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.TaskSchedulerApplication.Models.*;
import com.app.TaskSchedulerApplication.Respostiory.*;

import java.util.List;
import java.util.Optional;

@Service
public class TaskSchedulerService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskRuleRepository taskRuleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Scheduled(fixedRate = 30000)
    @Transactional
    public void scheduleTasks() {
        List<Job> jobs = jobRepository.findByJobStatusIn(List.of("Pending", "Processing"));

        for (Job job : jobs) {
            if ("Pending".equals(job.getJobStatus())) {
                createTasksForJob(job);
            } else if ("Processing".equals(job.getJobStatus())) {
                processTasksForJob(job);
            }
        }
    }
    
    public List<Task> getTasksByJob(Job job) {
        return taskRepository.findByJob(job);
    }
    
    private void createTasksForJob(Job job) {
        Customer customer = job.getCustomer();
        List<TaskRule> taskRules = taskRuleRepository.findAll();

        for (TaskRule taskRule : taskRules) {
            if (customer.getClientType().equals(taskRule.getClientType())) {
                Task task = new Task();
                task.setJob(job);
                task.setTaskSeqId(taskRule.getTaskSeqId());
                task.setDependentOnTaskSeqId(taskRule.getDependentOnTaskSeqId());
                task.setTaskStatus(taskRule.getTaskStatus());
                taskRepository.save(task);
            }
        }
        job.setJobStatus("Processing");
        jobRepository.save(job);
    }

    private void processTasksForJob(Job job) {
        List<Task> tasks = taskRepository.findByJobId(job.getId());

        for (Task task : tasks) {
            if ("Ready".equals(task.getTaskStatus())) {
                task.setTaskStatus("Processing");
            } else if ("Processing".equals(task.getTaskStatus())) {
                // simulate task processing
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.setTaskStatus("Completed");
            } else if ("Waiting".equals(task.getTaskStatus())) {
                boolean allDependenciesCompleted = checkDependenciesCompleted(task);
                if (allDependenciesCompleted) {
                    task.setTaskStatus("Ready");
                }
            }
            taskRepository.save(task);
        }

        boolean allTasksCompleted = tasks.stream().allMatch(t -> "Completed".equals(t.getTaskStatus()));
        if (allTasksCompleted) {
            job.setJobStatus("Completed");
            jobRepository.save(job);
        }
    }

    private boolean checkDependenciesCompleted(Task task) {
        String[] dependencies = task.getDependentOnTaskSeqId().split(",");
        for (String dependency : dependencies) {
            Optional<Task> dependentTask = taskRepository.findById(Long.valueOf(dependency));
            if (dependentTask.isPresent() && !"Completed".equals(dependentTask.get().getTaskStatus())) {
                return false;
            }
        }
        return true;
    }
}

