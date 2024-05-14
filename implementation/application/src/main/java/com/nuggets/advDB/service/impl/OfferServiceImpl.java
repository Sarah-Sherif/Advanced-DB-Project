package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Offer;
import com.nuggets.advDB.model.OfferId;
import com.nuggets.advDB.model.repository.OfferRepository;
import com.nuggets.advDB.model.repository.SupplierRepository;
import com.nuggets.advDB.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class OfferServiceImpl implements OfferService {

    @Autowired
    private final OfferRepository offerRepository;

    @Autowired
    private final SupplierRepository supplierRepository;

    public OfferServiceImpl(OfferRepository offerRepository, SupplierRepository supplierRepository) {
        this.offerRepository = offerRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void insertOffer(String componentModel, String supplierSSN) {
        if (supplierRepository.findBySSsn(supplierSSN).isEmpty()) {
            throw new IllegalArgumentException("Supplier with SSN " + supplierSSN + " does not exist");
        }
        OfferId offerId = new OfferId(componentModel, supplierSSN);
        offerRepository.save(new Offer(offerId, supplierRepository.findBySSsn(supplierSSN).get()));
    }
}
