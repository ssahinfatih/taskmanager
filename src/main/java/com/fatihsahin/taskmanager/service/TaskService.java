package com.fatihsahin.taskmanager.service;

import com.fatihsahin.taskmanager.entity.Task;
import com.fatihsahin.taskmanager.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public ResponseEntity<Task> findById(@PathVariable(name = "id") Long id) {
        Task task = taskRepository.findById(id).get();
        return ResponseEntity.ok(task);
    }

    public ResponseEntity<Task> save(@RequestBody Task task) {
        Task taskEntity = taskRepository.save(task);
        return ResponseEntity.ok(taskEntity);
    }

    public void deleteById(@PathVariable(name = "id") Long id) {
        taskRepository.deleteById(id);
    }

    public ResponseEntity<Task> update(@PathVariable(name = "id") Long id, @RequestBody Task task) {
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            optional.get().setTitle(task.getTitle());
            optional.get().setDescription(task.getDescription());
            optional.get().setCreatedAt(task.getCreatedAt());
            taskRepository.save(optional.get());
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
          /* Task taskEntity = taskRepository.findById(id).get();
        taskEntity.setTitle(task.getTitle());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setCompleted(task.isCompleted());

        return  ResponseEntity.ok(taskRepository.save(taskEntity));
*/
    }

}
