package com.advDB.carServiceCenter.service;

public interface PersonService {

    public void insertPerson(Long ssn, String birthdate, String email, String firstName, String middleName,
                             String lastName, String phoneNo);
}
