package com.advDB.carServiceCenter.model.repositories;

import com.advDB.carServiceCenter.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}