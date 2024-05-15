package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Transmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission, String> {
}