package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, String> {
}