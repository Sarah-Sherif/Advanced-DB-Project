package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Model;
import com.advDB.carServiceCenter.model.ModelId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, ModelId> {
}