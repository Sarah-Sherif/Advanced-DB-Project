package com.advDB.carServiceCenter.service;

import com.advDB.carServiceCenter.model.Customer;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

        public void insertCustomer(Long ssn, LocalDate birthdate, String email, String firstName, String middleName,
                                   String lastName, String city, Integer streetNo, Integer buildingNo, String district, String phoneNo);

        List<Customer> getAllCustomers();
}
