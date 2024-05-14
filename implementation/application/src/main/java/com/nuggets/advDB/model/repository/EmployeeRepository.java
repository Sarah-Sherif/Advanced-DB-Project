package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findByPerson_Ssn(@NonNull String ssn);
}