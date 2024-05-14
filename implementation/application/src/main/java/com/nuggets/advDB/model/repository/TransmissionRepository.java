package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission, String> {
}