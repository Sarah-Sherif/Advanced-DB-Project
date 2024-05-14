package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Person;
import com.nuggets.advDB.model.repository.PersonRepository;
import com.nuggets.advDB.service.PersonService;
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
    public void insertPerson(String ssn, String birthdate, String email, String firstName, String middleName, String lastName) {
        if (personRepository.findBySsn(ssn).isPresent()) {
            throw new IllegalArgumentException("Person with SSN " + ssn + " already exists");
        }
        personRepository.save(new Person(ssn, birthdate, email, firstName, middleName, lastName));
    }
}
