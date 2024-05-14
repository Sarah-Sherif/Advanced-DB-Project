package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {
}