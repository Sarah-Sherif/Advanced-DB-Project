package com.advDB.carServiceCenter.service;

import com.advDB.carServiceCenter.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {


        public void insertEmployee(Long ssn, LocalDate birthdate, String email, String firstName, String middleName,
                                   String lastName, String phoneNo, Double salary, Integer centerId, String role, String specialization);

        List<Employee> getAllEmployees();
}
