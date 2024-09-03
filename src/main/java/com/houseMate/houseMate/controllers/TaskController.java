package com.houseMate.houseMate.controllers;

import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TaskController {

private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @CrossOrigin(origins = "http://localhost:4001")
    @GetMapping
    public ResponseEntity<List <Task>> getTasks(){
        List<Task> tasks = taskService.getTasks();
        if(tasks.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tasks);
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @PostMapping("/create")
    public ResponseEntity<Object> saveTask(@RequestBody Task task ){
        taskService.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins = "http://localhost:4001")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTask (@PathVariable("id") int id){
        if(taskService.deleteTask(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @CrossOrigin(origins = "http://localhost:4001")
    @PutMapping("/{id}")
    public ResponseEntity<Object>updateTask(@PathVariable("id") int id, @RequestBody Task task) {
        if (taskService.updateTask(id,task )) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
    @CrossOrigin(origins = "http://localhost:4001")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable("id") int id){
        Optional<Task> task = taskService.getTaskById(id);
        if(task.isPresent()){
            return ResponseEntity.ok(task.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task not found");
    }




}


