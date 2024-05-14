package com.nuggets.advDB.model.repository;

import com.nuggets.advDB.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, String> {
    Optional<Car> findByPlateNo(@NonNull String plateNo);
}