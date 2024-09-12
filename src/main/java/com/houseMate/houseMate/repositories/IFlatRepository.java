/*
package com.houseMate.houseMate.repositories;

import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IFlatRepository extends JpaRepository <Flat ,Integer>{
    List<Flat> getTasks();

    Optional<Task> getTaskById(int id);

    void saveTask(Task task);
}
*/
package com.houseMate.houseMate.repositories;

import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IFlatRepository  extends JpaRepository<Flat,Integer> {
    List<Flat> findByUserEmail(String email);
}

