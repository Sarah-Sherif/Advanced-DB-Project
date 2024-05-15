package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findBySsn(@NonNull Long ssn);
}