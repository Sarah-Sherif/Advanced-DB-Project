package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}