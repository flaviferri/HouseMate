package com.houseMate.houseMate.controllers;

import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.services.ITaskService;
import com.houseMate.houseMate.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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


    @PostMapping("/create")
    public ResponseEntity<Object> saveTask(@RequestBody Task task) {
        return taskServ.saveTask(task);

    }

    @CrossOrigin(origins = "http://localhost:4001")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable("id") int id) {
        if (taskServ.deleteTask(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        if (taskServ.updateTask(id, task)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }


    @CrossOrigin(origins = "http://localhost:4001")
    @GetMapping("/task/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable("id") int id) {
        Optional<Task> task = taskServ.getTaskById(id);
        if (task.isPresent()) {
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }
}





