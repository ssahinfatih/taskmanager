package com.fatihsahin.taskmanager.controller;

import com.fatihsahin.taskmanager.entity.Task;
import com.fatihsahin.taskmanager.repository.TaskRepository;
import com.fatihsahin.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController( TaskService taskService) {//constructor inject
        this.taskService = taskService;
    }

    @GetMapping("/list")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Task> findById(@PathVariable(name = "id") Long id) {
        return taskService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task) {
        return taskService.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        taskService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Task> update(@PathVariable(name = "id") Long id, @RequestBody Task task) {
      return  taskService.update(id, task);
    }

}
