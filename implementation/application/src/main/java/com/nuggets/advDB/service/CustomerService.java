package com.nuggets.advDB.service;

public interface CustomerService {

    public void insertCustomer(String ssn, String birthdate, String email, String firstName, String middleName,
                               String lastName, String city, Integer streetNo, Long buildingNo, String district, String phoneNo);
}
