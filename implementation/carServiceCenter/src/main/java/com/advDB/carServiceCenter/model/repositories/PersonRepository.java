package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}