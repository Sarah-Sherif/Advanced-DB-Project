package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Person;
import com.nuggets.advDB.model.Supplier;
import com.nuggets.advDB.model.repository.PersonRepository;
import com.nuggets.advDB.model.repository.SupplierRepository;
import com.nuggets.advDB.service.PersonPhoneNOService;
import com.nuggets.advDB.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private final SupplierRepository supplierRepository;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final PersonPhoneNOService personPhoneNOService;

    public SupplierServiceImpl(SupplierRepository supplierRepository, PersonRepository personRepository, PersonPhoneNOService personPhoneNOService) {
        this.supplierRepository = supplierRepository;
        this.personRepository = personRepository;
        this.personPhoneNOService = personPhoneNOService;
    }

    @Override
    public void insertSupplier(String ssn, String birthDate, String email, String firstName, String middleName,
                               String lastName, String website, String phoneNo) {
        if (personRepository.findBySsn(ssn).isPresent()) {
            throw new IllegalArgumentException("Supplier with SSN " + ssn + " already exists");
        }
        personRepository.save(new Person(ssn, birthDate, email, firstName, middleName, lastName));
        supplierRepository.save(new Supplier(ssn, personRepository.findBySsn(ssn).get(), website));
        personPhoneNOService.insertPersonPhoneNO(ssn, phoneNo);
    }

}
