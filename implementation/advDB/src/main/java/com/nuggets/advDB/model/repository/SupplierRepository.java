package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, String> {
    Optional<Supplier> findBySSsn(String sSsn);
}