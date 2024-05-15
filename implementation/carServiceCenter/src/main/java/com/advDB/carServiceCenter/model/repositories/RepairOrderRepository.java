package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairOrderRepository extends JpaRepository<RepairOrder, String> {
}