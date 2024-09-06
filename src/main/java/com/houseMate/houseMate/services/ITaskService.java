package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Task;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITaskService {

    List<Task> getTasks();
    Optional<Task> getTaskById(int id);
    ResponseEntity<Object> saveTask(Task task);
    boolean updateTask(int id, Task task);
    boolean deleteTask(int id);

}
