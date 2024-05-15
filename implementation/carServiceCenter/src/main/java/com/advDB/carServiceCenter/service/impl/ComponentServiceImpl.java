package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.Body;
import com.advDB.carServiceCenter.model.Component;
import com.advDB.carServiceCenter.model.repositories.BodyRepository;
import com.advDB.carServiceCenter.model.repositories.ComponentRepository;
import com.advDB.carServiceCenter.model.repositories.SupplierRepository;
import com.advDB.carServiceCenter.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentServiceImpl implements ComponentService {

    @Autowired
    private final ComponentRepository componentRepository;

    @Autowired
    private final BodyRepository bodyRepository;

    @Autowired
    private final SupplierRepository supplierRepository;


    public ComponentServiceImpl(ComponentRepository componentRepository, BodyRepository bodyRepository, SupplierRepository supplierRepository) {
        this.componentRepository = componentRepository;
        this.bodyRepository = bodyRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void insertComponent(String model, Double price, Long supplierSSN) {
        if (supplierRepository.findBySsn(supplierSSN).isEmpty()) {
            throw new IllegalArgumentException("Supplier with SSN " + supplierSSN + " does not exist");
        }
        componentRepository.save(new Component(model, price));
        if (model.startsWith("A")){
            bodyRepository.save(new Body(model));
        }
//        TODO create trigger to insert in offer table
    }
}
