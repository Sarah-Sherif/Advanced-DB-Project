package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Battery;
import com.nuggets.advDB.model.repository.BatteryRepository;
import com.nuggets.advDB.model.repository.ComponentRepository;
import com.nuggets.advDB.service.BatteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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
    public void insertBattery(String model, LocalDate expiryDate) {
        if (componentRepository.findByModel(model).isEmpty()) {
            throw new IllegalArgumentException("Battery with model " + model + " does not exist");
        }
        batteryRepository.save(new Battery(model, expiryDate));
    }
}
