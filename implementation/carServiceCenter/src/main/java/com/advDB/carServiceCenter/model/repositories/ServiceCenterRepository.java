package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, String> {
}