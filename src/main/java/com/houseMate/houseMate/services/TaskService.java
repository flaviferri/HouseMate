package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.repositories.ITaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository repoTask;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Task> getTasks() {
       return repoTask.findAll();

    }

    @Override
    public ResponseEntity<Object> getTaskById(int id) {
        Optional<Task> taskOptional = repoTask.findById(id);

        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            return new ResponseEntity<>(task, HttpStatus.OK);
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Object> saveTask(Task task) {
        repoTask.save(task);
        return new ResponseEntity <>(task,HttpStatus.CREATED);

    }
    @Override
    public ResponseEntity<Task> updateTask(int id, Task task) {
        if (repoTask.existsById(id)) {
            task.setId(id);
            Task updatedTask = repoTask.save(task);
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.notFound().build();
    }


    @Override
    public ResponseEntity<Void> deleteTask(int id) {
        if (repoTask.existsById(id)) {
            repoTask.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}



