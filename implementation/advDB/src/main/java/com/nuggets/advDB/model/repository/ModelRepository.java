package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Model;
import com.nuggets.advDB.model.ModelId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, ModelId> {
    @Override
    Optional<Model> findById(ModelId modelId);
}