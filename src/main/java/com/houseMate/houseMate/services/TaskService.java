package com.houseMate.houseMate.services;



import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.repositories.ITaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import com.houseMate.houseMate.models.Category;
import com.houseMate.houseMate.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
       return repoTask.findAllByOrderByIdAsc();

    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return repoTask.findById(id);
    }

    @Override
    public ResponseEntity<Object> saveTask(Task task) {
        repoTask.save(task);
        return new ResponseEntity <>(task,HttpStatus.CREATED);

    }

    @Override
    public boolean updateTask(int id, Task task) {
        if (repoTask.existsById(id)) {
            task.setId(id);
            repoTask.save(task);
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteTask(int id) {
        if (repoTask.existsById(id)) {
            repoTask.deleteById(id);
            return true;
        }
        return false;
    }

}



