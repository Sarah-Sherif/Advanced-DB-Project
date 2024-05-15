package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Model;
import com.advDB.carServiceCenter.model.ModelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, ModelId> {
    Optional<Model> findByModelId(@NonNull ModelId modelId);

    Optional<Model> findByModelId_ModelNameAndModelId_ModelYear(@NonNull String modelName, @NonNull int modelYear);
}