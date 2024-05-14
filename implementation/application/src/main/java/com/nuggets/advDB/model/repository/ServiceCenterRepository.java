package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {

    Optional<ServiceCenter> findByManager_ESsn(@NonNull String eSsn);

    @Override
    Optional<ServiceCenter> findById(Long aLong);
}