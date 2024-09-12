package com.houseMate.houseMate.repositories;

import com.houseMate.houseMate.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository <Category,Integer>{
}
