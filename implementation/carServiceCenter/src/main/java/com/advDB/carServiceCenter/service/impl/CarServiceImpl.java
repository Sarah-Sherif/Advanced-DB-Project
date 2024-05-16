package com.advDB.carServiceCenter.service.impl;


import com.advDB.carServiceCenter.model.Car;
import com.advDB.carServiceCenter.model.repositories.CarRepository;
import com.advDB.carServiceCenter.model.repositories.CustomerRepository;
import com.advDB.carServiceCenter.model.repositories.ModelRepository;
import com.advDB.carServiceCenter.service.CarService;
import com.advDB.carServiceCenter.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final ModelRepository modelRepository;

    @Autowired
    private final ModelService modelService;

    public CarServiceImpl(CarRepository carRepository, CustomerRepository customerRepository, ModelRepository modelRepository, ModelService modelService) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelRepository = modelRepository;
        this.modelService = modelService;
    }

    @Override
    public void insertCar(String plateNo, String modelName, Integer modelYear, String brand,  Long ssn) {
        if (customerRepository.findBySsn(ssn).isEmpty()) {
            throw new IllegalArgumentException("Customer with SSN " + ssn + " does not exist");
        }
        modelService.insertModel(modelName, modelYear, brand);
        carRepository.save(new Car(plateNo, customerRepository.findBySsn(ssn).get(), modelRepository.findByModelId_ModelNameAndModelId_ModelYear(modelName, modelYear).get()));
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
