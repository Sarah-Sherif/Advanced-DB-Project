package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findBySsn(@NonNull Long ssn);
}