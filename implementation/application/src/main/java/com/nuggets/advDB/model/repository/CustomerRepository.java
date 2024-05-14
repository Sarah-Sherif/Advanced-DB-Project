package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {


    Optional<Customer> findByCSsn(String cSsn);
}