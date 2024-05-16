package com.advDB.carServiceCenter.service;

import com.advDB.carServiceCenter.model.Car;

import java.util.List;

public interface CarService {

        void insertCar(String plateNo, String modelName, Integer modelYear, String brand, Long ssn);

        List<Car> getAllCars();
}
