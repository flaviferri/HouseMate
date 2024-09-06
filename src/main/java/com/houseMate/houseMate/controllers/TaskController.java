package com.houseMate.houseMate.controllers;

import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private ITaskService taskServ;

    @CrossOrigin(origins = "http://localhost:4001")
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskServ.getTasks();
        if (tasks.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }


    @PostMapping("/task/create")
    public ResponseEntity<Object> saveTask(@RequestBody Task task) {
        return taskServ.saveTask(task);

    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
        return taskServ.deleteTask(id);

    }

    @CrossOrigin(origins = "http://localhost:4001")
    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        return taskServ.updateTask(id, task);
    }


    @GetMapping("/task/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable("id") int id) {
        return taskServ.getTaskById(id);
    }
}





