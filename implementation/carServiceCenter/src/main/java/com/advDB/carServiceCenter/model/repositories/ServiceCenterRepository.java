package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, String> {
    Optional<ServiceCenter> findByCenterID(Integer centerID);

    Optional<ServiceCenter> findByManager_Ssn(Long ssn);
}