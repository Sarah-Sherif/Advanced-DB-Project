package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface EngineerRepository extends JpaRepository<Engineer, String> {
    Optional<Engineer> findByESsn(@NonNull String eSsn);
}