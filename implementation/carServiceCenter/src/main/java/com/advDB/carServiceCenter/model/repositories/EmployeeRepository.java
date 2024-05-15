package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findBySsn(@NonNull Long ssn);
}