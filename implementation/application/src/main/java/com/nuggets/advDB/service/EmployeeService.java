package com.nuggets.advDB.service;

public interface EmployeeService {

    public void insertEmployee(String ssn, String birthDate, String email, String firstName, String middleName,
                               String lastName, String phoneNo, Double salary, Long centerId, String role);
}
