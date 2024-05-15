package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.Person;
import com.advDB.carServiceCenter.model.repositories.PersonRepository;
import com.advDB.carServiceCenter.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void insertPerson(Long ssn, String birthdate, String email, String firstName, String middleName, String lastName, String phoneNo) {
        if (personRepository.findBySsn(ssn).isPresent()) {
            throw new IllegalArgumentException("Person with SSN " + ssn + " already exists");
        }
        personRepository.save(new Person(ssn, firstName, middleName, lastName, birthdate, phoneNo, email));
    }
}
