package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, String> {
}