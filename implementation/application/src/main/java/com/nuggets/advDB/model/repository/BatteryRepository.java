package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery, String> {
}