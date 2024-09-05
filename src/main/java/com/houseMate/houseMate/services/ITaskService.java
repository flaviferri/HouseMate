package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ITaskService {

    List<Task> getTasks();
    Optional<Task> getTaskById(int id);
    void saveTask(Task task);
    boolean updateTask(int id, Task task);
    boolean patchTask(int id, String title, String description, Integer category, Integer status, LocalDate entryDate, LocalDate deadlineDate);
    boolean deleteTask(int id);

}
