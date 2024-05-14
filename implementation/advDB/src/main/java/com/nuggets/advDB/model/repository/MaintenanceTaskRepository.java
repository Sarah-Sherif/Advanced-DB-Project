package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.MaintenanceTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, Long> {
}