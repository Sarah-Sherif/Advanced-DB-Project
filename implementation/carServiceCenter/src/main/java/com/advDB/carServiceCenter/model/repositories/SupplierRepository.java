package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findBySsn(@NonNull Long ssn);
}