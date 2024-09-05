package com.houseMate.houseMate.services;



import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.repositories.ITaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import com.houseMate.houseMate.models.Category;
import com.houseMate.houseMate.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void saveTask(Task task) {
        repoTask.save(task);
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
    @Transactional
    public boolean patchTask(int id, String title, String description, Integer categoryId, Integer statusId, LocalDate entryDate, LocalDate deadlineDate) {
        Task task = repoTask.findById(id).orElse(null);

        if (task != null) {
            if (title != null) {
                task.setTitle(title);
            }

            if (description != null) {
                task.setDescription(description);
            }

            if (categoryId != null) {
                Category category = entityManager.find(Category.class, categoryId);
                if (category != null) {
                    task.setCategory(category);
                } else {

                }
            }

            if (statusId != null) {
                Status status = entityManager.find(Status.class, statusId);
                if (status != null) {
                    task.setStatus(status);
                } else {

                }
            }

            if (entryDate != null) {
                task.setEntry_date(entryDate);
            }

            if (deadlineDate != null) {
                task.setDeadline_date(deadlineDate);
            }


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



