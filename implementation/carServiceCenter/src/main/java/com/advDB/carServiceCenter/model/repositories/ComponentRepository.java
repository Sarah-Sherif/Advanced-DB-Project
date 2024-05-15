package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ComponentRepository extends JpaRepository<Component, String> {

    Optional<Component> findByComponentModel(@NonNull String componentModel);
}