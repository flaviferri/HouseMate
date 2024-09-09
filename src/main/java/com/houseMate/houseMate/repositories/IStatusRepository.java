package com.houseMate.houseMate.repositories;

import com.houseMate.houseMate.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepository extends JpaRepository<Status,Integer> {
}
