package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {

    Optional<Person> findBySsn(@NonNull String ssn);
}