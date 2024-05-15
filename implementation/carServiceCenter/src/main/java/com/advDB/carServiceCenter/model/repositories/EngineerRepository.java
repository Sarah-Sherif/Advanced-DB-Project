package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    Optional<Engineer> findBySsn(@NonNull Long ssn);
}