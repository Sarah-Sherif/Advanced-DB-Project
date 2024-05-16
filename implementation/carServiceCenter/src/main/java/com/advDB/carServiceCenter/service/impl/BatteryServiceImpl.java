package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.Battery;
import com.advDB.carServiceCenter.model.repositories.BatteryRepository;
import com.advDB.carServiceCenter.model.repositories.ComponentRepository;
import com.advDB.carServiceCenter.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatteryServiceImpl implements BatteryService {

    @Autowired
    private final BatteryRepository batteryRepository;

    @Autowired
    private final ComponentRepository componentRepository;

    public BatteryServiceImpl(BatteryRepository batteryRepository, ComponentRepository componentRepository) {
        this.batteryRepository = batteryRepository;
        this.componentRepository = componentRepository;
    }

    @Override
    public void insertBattery(String model, String expiryDate, Double price) {
        if (componentRepository.findByComponentModel(model).isEmpty()) {
            throw new IllegalArgumentException("Battery with model " + model + " does not exist");
        }
        batteryRepository.save(new Battery(model, expiryDate, price));
    }
}
