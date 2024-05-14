package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Customer;
import com.nuggets.advDB.model.repository.CustomerRepository;
import com.nuggets.advDB.service.CustomerService;
import com.nuggets.advDB.service.PersonPhoneNOService;
import com.nuggets.advDB.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final PersonPhoneNOService personPhoneNOService;

    @Autowired
    private final PersonService personService;

    public CustomerServiceImpl(CustomerRepository customerRepository, PersonPhoneNOService personPhoneNOService, PersonService personService) {
        this.customerRepository = customerRepository;
        this.personPhoneNOService = personPhoneNOService;
        this.personService = personService;
    }
    @Override
    public void insertCustomer(String ssn, String birthdate, String email, String firstName, String middleName,
                               String lastName, String city, Integer streetNo, Long buildingNo, String district, String phoneNo) {

        personService.insertPerson(ssn, birthdate, email, firstName, middleName, lastName);
        customerRepository.save(new Customer(ssn, city, streetNo, buildingNo, district));
        personPhoneNOService.insertPersonPhoneNO(ssn, phoneNo);
    }
}
