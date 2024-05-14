package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Body;
import com.nuggets.advDB.model.Component;
import com.nuggets.advDB.model.repository.BodyRepository;
import com.nuggets.advDB.model.repository.ComponentRepository;
import com.nuggets.advDB.model.repository.SupplierRepository;
import com.nuggets.advDB.service.ComponentService;
import com.nuggets.advDB.service.OfferService;
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

    @Autowired
    private final OfferService offerService;


    public ComponentServiceImpl(ComponentRepository componentRepository, BodyRepository bodyRepository, SupplierRepository supplierRepository, OfferService offerService) {
        this.componentRepository = componentRepository;
        this.bodyRepository = bodyRepository;
        this.supplierRepository = supplierRepository;
        this.offerService = offerService;
    }

    @Override
    public void insertComponent(String model, Double price, String supplierSSN) {
        if (supplierRepository.findBySSsn(supplierSSN).isEmpty()) {
            throw new IllegalArgumentException("Supplier with SSN " + supplierSSN + " does not exist");
        }
        componentRepository.save(new Component(model, price));
        if (model.startsWith("A")){
            bodyRepository.save(new Body(model));
        }
        offerService.insertOffer(model, supplierSSN);
    }
}
