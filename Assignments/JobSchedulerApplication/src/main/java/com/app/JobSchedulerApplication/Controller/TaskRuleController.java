package com.app.JobSchedulerApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.JobSchedulerApplication.Models.Task_Rule;
import com.app.JobSchedulerApplication.Repository.TaskRuleRepository;

@RestController
@RequestMapping("/task-rule")
public class TaskRuleController {

    @Autowired
    private TaskRuleRepository taskRuleRepository;

    @GetMapping("/all")
    public List<Task_Rule> getAllTaskRules() {
        return taskRuleRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task_Rule> getTaskRuleById(@PathVariable int id) {
        return taskRuleRepository.findById(id)
                .map(taskRule -> ResponseEntity.ok().body(taskRule))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public Task_Rule createTaskRule(@RequestBody Task_Rule taskRule) {
        return taskRuleRepository.save(taskRule);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task_Rule> updateTaskRule(@PathVariable int id, @RequestBody Task_Rule taskRuleDetails) {
        return taskRuleRepository.findById(id)
                .map(taskRule -> {
                    taskRule.setClientType(taskRuleDetails.getClientType());
                    taskRule.setTaskSeqId(taskRuleDetails.getTaskSeqId());
                    taskRule.setDependendOnTaskSeqId(taskRuleDetails.getDependendOnTaskSeqId());
                    taskRule.setTaskStatus(taskRuleDetails.getTaskStatus());
                    Task_Rule updatedTaskRule = taskRuleRepository.save(taskRule);
                    return ResponseEntity.ok().body(updatedTaskRule);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTaskRule(@PathVariable int id) {
        return taskRuleRepository.findById(id)
                .map(taskRule -> {
                    taskRuleRepository.delete(taskRule);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

