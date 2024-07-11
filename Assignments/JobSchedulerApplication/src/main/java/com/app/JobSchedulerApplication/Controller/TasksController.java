package com.app.JobSchedulerApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.JobSchedulerApplication.Models.Tasks;
import com.app.JobSchedulerApplication.Repository.TaskRepository;

@RestController
@RequestMapping("/task")
public class TasksController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/all")
    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable int id) {
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/new")
    public Tasks createTask(@RequestBody Tasks task) {
        return taskRepository.save(task);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable int id, @RequestBody Tasks taskDetails) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setJobId(taskDetails.getJobId());
                    task.setTaskSeqId(taskDetails.getTaskSeqId());
                    task.setDependentOnTaskSeqId(taskDetails.getDependentOnTaskSeqId());
                    task.setTaskStatus(taskDetails.getTaskStatus());
                    Tasks updatedTask = taskRepository.save(task);
                    return ResponseEntity.ok().body(updatedTask);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id) {
        return taskRepository.findById(id)
                .map(task -> {
                    taskRepository.delete(task);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}

