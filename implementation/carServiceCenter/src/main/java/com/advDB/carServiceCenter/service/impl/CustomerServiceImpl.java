package com.advDB.carServiceCenter.service.impl;


import com.advDB.carServiceCenter.model.Customer;
import com.advDB.carServiceCenter.model.repositories.CustomerRepository;
import com.advDB.carServiceCenter.service.CustomerService;
import com.advDB.carServiceCenter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;


    @Autowired
    private final PersonService personService;

    public CustomerServiceImpl(CustomerRepository customerRepository, PersonService personService) {
        this.customerRepository = customerRepository;
        this.personService = personService;
    }

    @Override
    public void insertCustomer(Long ssn, String birthdate, String email, String firstName, String middleName, String lastName, String city, Integer streetNo, Integer buildingNo, String district, String phoneNo) {
        if (customerRepository.findBySsn(ssn).isPresent()) {
            throw new IllegalArgumentException("Customer with SSN " + ssn + " already exists");
        }
        personService.insertPerson(ssn, birthdate, email, firstName, middleName, lastName, phoneNo);
        customerRepository.save(new Customer(ssn, city, streetNo, buildingNo, district, firstName, middleName, lastName, birthdate, phoneNo, email));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
