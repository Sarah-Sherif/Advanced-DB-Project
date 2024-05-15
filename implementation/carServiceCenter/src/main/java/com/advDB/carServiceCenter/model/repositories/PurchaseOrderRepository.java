package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, String> {
}