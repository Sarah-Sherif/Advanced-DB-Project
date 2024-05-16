package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.Transmission;
import com.advDB.carServiceCenter.model.repositories.ComponentRepository;
import com.advDB.carServiceCenter.model.repositories.TransmissionRepository;
import com.advDB.carServiceCenter.service.TransmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransmissionServiceImpl implements TransmissionService {

    @Autowired
    private final TransmissionRepository transmissionRepository;

    @Autowired
    private final ComponentRepository componentRepository;

    public TransmissionServiceImpl(TransmissionRepository transmissionRepository, ComponentRepository componentRepository){
        this.transmissionRepository = transmissionRepository;
        this.componentRepository = componentRepository;
    }

    @Override
    public void insertTransmission(String model, String transmissionType, Double price) {
        if (componentRepository.findByComponentModel(model).isEmpty()) {
            throw new IllegalArgumentException("Transmission with model " + model + " does not exist");
        }
        transmissionRepository.save(new Transmission(model, transmissionType, price));
    }
}
