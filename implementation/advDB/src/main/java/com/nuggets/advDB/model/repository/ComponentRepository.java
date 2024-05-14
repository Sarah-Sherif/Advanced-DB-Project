package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComponentRepository extends JpaRepository<Component, String> {


    Optional<Component> findByModel(String model);
}