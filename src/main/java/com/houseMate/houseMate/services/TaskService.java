package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Task;
import com.houseMate.houseMate.repositories.TaskRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAllByOrderByIdAsc();
    }

    public Optional<Task> getTaskById(int id){
        return taskRepository.findById(id);
    }

    public void saveTask (Task task){
        taskRepository.save(task);
    }

    public boolean updateTask ( int id, Task task){
        if (taskRepository.existsById(id)){
            task.setId(id);
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    public boolean deleteTask ( int id){
        if ( taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
