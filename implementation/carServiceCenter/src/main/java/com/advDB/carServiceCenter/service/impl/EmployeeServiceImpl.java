package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.Employee;
import com.advDB.carServiceCenter.model.Engineer;
import com.advDB.carServiceCenter.model.SalesMan;
import com.advDB.carServiceCenter.model.repositories.*;
import com.advDB.carServiceCenter.service.EmployeeService;
import com.advDB.carServiceCenter.service.PersonService;
import com.advDB.carServiceCenter.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final PersonRepository personRepository;


    @Autowired
    private final ServiceCenterRepository serviceCenterRepository;

    @Autowired
    private final EngineerRepository engineerRepository;

    @Autowired
    private final SalesManRepository salesManRepository;

    @Autowired
    private final PersonService personService;

    @Autowired
    private final ServiceCenterService serviceCenterService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PersonRepository personRepository, ServiceCenterRepository serviceCenterRepository, EngineerRepository engineerRepository, SalesManRepository salesManRepository, PersonService personService, ServiceCenterService serviceCenterService) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
        this.serviceCenterRepository = serviceCenterRepository;
        this.engineerRepository = engineerRepository;
        this.salesManRepository = salesManRepository;
        this.personService = personService;
        this.serviceCenterService = serviceCenterService;
    }

    @Override
    public void insertEmployee(Long ssn, LocalDate birthdate, String email, String firstName, String middleName, String lastName, String phoneNo, Double salary, Integer centerId, String role, String specialization) {
        if (personRepository.findBySsn(ssn).isPresent()) {
            throw new IllegalArgumentException("Employee with SSN " + ssn + " already exists");
        }
        if (serviceCenterRepository.findByCenterID(centerId).isEmpty()) {
            throw new IllegalArgumentException("Service Center with ID " + centerId + " does not exist");
        }
        personService.insertPerson(ssn, birthdate, email, firstName, middleName, lastName, phoneNo);
        if (role.equals("Engineer")) {
            engineerRepository.save(new Engineer(ssn, firstName, middleName, lastName, birthdate, phoneNo, email, salary, serviceCenterRepository.findByCenterID(centerId).get(), specialization));

        }
        else if (role.equals("SalesMan")) {
            salesManRepository.save(new SalesMan(ssn, firstName, middleName, lastName, birthdate, phoneNo, email, salary, serviceCenterRepository.findByCenterID(centerId).get()));
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
