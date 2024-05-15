package com.advDB.carServiceCenter.service;

public interface CustomerService {

        public void insertCustomer(Long ssn, String birthdate, String email, String firstName, String middleName,
                                String lastName, String city, Integer streetNo, Integer buildingNo, String district, String phoneNo);
}
