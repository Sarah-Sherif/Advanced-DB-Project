package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Battery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatteryRepository extends JpaRepository<Battery, String> {
}