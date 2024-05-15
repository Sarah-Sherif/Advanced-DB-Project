package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentRepository extends JpaRepository<Component, String> {
}