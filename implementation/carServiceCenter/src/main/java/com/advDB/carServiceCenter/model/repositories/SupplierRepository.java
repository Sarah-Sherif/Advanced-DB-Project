package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}