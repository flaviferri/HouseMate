package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Task;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ITaskService {

    ResponseEntity<List<Task>> getTasks();
    ResponseEntity<Object> getTaskById(int id);
    ResponseEntity<Object> saveTask(Task task);
    ResponseEntity<Task> updateTask(int Task, Task task);
    ResponseEntity<Void> deleteTask(int id);

}
