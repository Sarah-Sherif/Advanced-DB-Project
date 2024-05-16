package com.advDB.carServiceCenter.service;

import com.advDB.carServiceCenter.model.Employee;

import java.util.List;

public interface EmployeeService {


        public void insertEmployee(Long ssn, String birthdate, String email, String firstName, String middleName,
                                  String lastName, String phoneNo, Double salary, Integer centerId, String role, String specialization);

        List<Employee> getAllEmployees();
}
