package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.PersonPhoneNo;
import com.nuggets.advDB.model.PersonPhoneNoId;
import com.nuggets.advDB.model.repository.PersonPhoneNoRepository;
import com.nuggets.advDB.model.repository.PersonRepository;
import com.nuggets.advDB.service.PersonPhoneNOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonPhoneNOServiceImpl implements PersonPhoneNOService {

    @Autowired
    private final PersonPhoneNoRepository personPhoneNoRepository;

    @Autowired
    private final PersonRepository personRepository;

    public PersonPhoneNOServiceImpl(PersonPhoneNoRepository personPhoneNoRepository, PersonRepository personRepository) {
        this.personPhoneNoRepository = personPhoneNoRepository;
        this.personRepository = personRepository;
    }

    @Override
    public void insertPersonPhoneNO(String ssn, String phoneNO) {
        if (!personRepository.findBySsn(ssn).isPresent()) {
            throw new IllegalArgumentException("Person with SSN " + ssn + " does not exist");
        }
        PersonPhoneNoId personPhoneNoId = new PersonPhoneNoId(ssn, phoneNO);
        personPhoneNoRepository.save(new PersonPhoneNo(personPhoneNoId, personRepository.findBySsn(ssn).get()));
    }
}
