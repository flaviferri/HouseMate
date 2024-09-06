package com.houseMate.houseMate.repositories;

import com.houseMate.houseMate.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITaskRepository  extends JpaRepository<Task,Integer> {
  /*  List<Task> findAllByOrderByIdAsc();*/
}
