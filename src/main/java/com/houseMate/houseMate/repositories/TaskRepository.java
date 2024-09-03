package com.houseMate.houseMate.repositories;

import com.houseMate.houseMate.models.Task;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface TaskRepository extends JpaRepository {

    List<Task> findAllByOrderByIdAsc();

}