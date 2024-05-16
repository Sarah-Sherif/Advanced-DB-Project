package com.advDB.carServiceCenter.service;

import java.time.LocalDate;

public interface PersonService {

    public void insertPerson(Long ssn, LocalDate birthdate, String email, String firstName, String middleName,
                             String lastName, String phoneNo);
}
