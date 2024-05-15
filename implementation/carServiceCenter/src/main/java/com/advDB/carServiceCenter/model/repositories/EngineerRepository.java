package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
}