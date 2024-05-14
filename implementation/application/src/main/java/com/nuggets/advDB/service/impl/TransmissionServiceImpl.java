package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Transmission;
import com.nuggets.advDB.model.repository.ComponentRepository;
import com.nuggets.advDB.model.repository.TransmissionRepository;
import com.nuggets.advDB.service.TransmissionService;
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
    public void insertTransmission(String model, String transmissionType) {
        if (componentRepository.findByModel(model).isEmpty()) {
            throw new IllegalArgumentException("Transmission with model " + model + " does not exist");
        }
        transmissionRepository.save(new Transmission(model, transmissionType));
    }
}

