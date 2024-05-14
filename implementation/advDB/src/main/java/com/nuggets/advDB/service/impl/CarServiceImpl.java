package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Car;
import com.nuggets.advDB.model.Model;
import com.nuggets.advDB.model.ModelId;
import com.nuggets.advDB.model.repository.CarRepository;
import com.nuggets.advDB.model.repository.CustomerRepository;
import com.nuggets.advDB.model.repository.ModelRepository;
import com.nuggets.advDB.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private final CarRepository carRepository;

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final ModelRepository modelRepository;

    public CarServiceImpl(CarRepository carRepository, CustomerRepository customerRepository, ModelRepository modelRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void insertCar(String plateNo, String modelName, Integer modelYear, String ssn) {
        if (customerRepository.findByCSsn(ssn).isEmpty()) {
            throw new IllegalArgumentException("Customer with SSN " + ssn + " does not exist");
        }
        ModelId modelId = new ModelId(modelName, modelYear);
        if (modelRepository.findById(modelId).isEmpty()) {
            throw new IllegalArgumentException("Model with name " + modelName + " and year " + modelYear + " does not exist");
        }
        Model model = modelRepository.findById(modelId).get();
        carRepository.save(new Car(plateNo, model, customerRepository.findByCSsn(ssn).get()));
    }
}
