package com.houseMate.houseMate.controllers;

import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private ITaskService taskServ;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks() {
        return taskServ.getTasks();
    }
    @PostMapping("/task/create")
    public ResponseEntity<Object> saveTask(@RequestBody Task task) {
        return taskServ.saveTask(task);
    }
    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") int id) {
        return taskServ.deleteTask(id);
    }
    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        return taskServ.updateTask(id, task);
    }
    @GetMapping("/task/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable("id") int id) {
        return taskServ.getTaskById(id);
    }
}





