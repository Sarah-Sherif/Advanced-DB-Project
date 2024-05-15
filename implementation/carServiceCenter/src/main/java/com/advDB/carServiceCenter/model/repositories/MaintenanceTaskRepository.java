package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.MaintenanceTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceTaskRepository extends JpaRepository<MaintenanceTask, String> {
}