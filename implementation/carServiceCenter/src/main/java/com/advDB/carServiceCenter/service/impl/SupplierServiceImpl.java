package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.Supplier;
import com.advDB.carServiceCenter.model.repositories.PersonRepository;
import com.advDB.carServiceCenter.model.repositories.SupplierRepository;
import com.advDB.carServiceCenter.service.PersonService;
import com.advDB.carServiceCenter.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private final SupplierRepository supplierRepository;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final PersonService personService;

    public SupplierServiceImpl(SupplierRepository supplierRepository, PersonRepository personRepository, PersonService personService) {
        this.supplierRepository = supplierRepository;
        this.personRepository = personRepository;
        this.personService = personService;
    }

    @Override
    public void insertSupplier(Long ssn, String birthDate, String email, String firstName, String middleName, String lastName, String website, String phoneNo) {
        if (personRepository.findBySsn(ssn).isPresent()) {
            throw new IllegalArgumentException("Supplier with SSN " + ssn + " already exists");
        }
        personService.insertPerson(ssn, birthDate, email, firstName, middleName, lastName, phoneNo);
        supplierRepository.save(new Supplier(ssn, firstName, middleName, lastName, birthDate, email, website, phoneNo));
    }
}
