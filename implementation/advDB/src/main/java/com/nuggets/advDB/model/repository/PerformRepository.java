package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Perform;
import com.nuggets.advDB.model.PerformId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformRepository extends JpaRepository<Perform, PerformId> {
}