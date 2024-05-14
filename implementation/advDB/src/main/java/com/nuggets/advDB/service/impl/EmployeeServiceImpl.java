package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.Employee;
import com.nuggets.advDB.model.Engineer;
import com.nuggets.advDB.model.SalesMan;
import com.nuggets.advDB.model.repository.*;
import com.nuggets.advDB.service.EmployeeService;
import com.nuggets.advDB.service.PersonPhoneNOService;
import com.nuggets.advDB.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final PersonPhoneNOService personPhoneNOService;

    @Autowired
    private final ServiceCenterRepository serviceCenterRepository;

    @Autowired
    private final EngineerRepository engineerRepository;

    @Autowired
    private final SalesManRepository salesManRepository;

    @Autowired
    private final PersonService personService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, PersonRepository personRepository, PersonPhoneNOService personPhoneNOService, ServiceCenterRepository serviceCenterRepository, EngineerRepository engineerRepository, SalesManRepository salesManRepository, PersonService personService) {
        this.employeeRepository = employeeRepository;
        this.personRepository = personRepository;
        this.personPhoneNOService = personPhoneNOService;
        this.serviceCenterRepository = serviceCenterRepository;
        this.engineerRepository = engineerRepository;
        this.salesManRepository = salesManRepository;
        this.personService = personService;
    }

    @Override
    public void insertEmployee(String ssn, String birthDate, String email, String firstName, String middleName,
                               String lastName, String phoneNo, Double salary, String centerId, String role) {

        personService.insertPerson(ssn, birthDate, email, firstName, middleName, lastName);
        employeeRepository.save(new Employee(ssn, personRepository.findBySsn(ssn).get(), salary,
                serviceCenterRepository.findByManager_ESsn(ssn).get(), role));
        personPhoneNOService.insertPersonPhoneNO(ssn, phoneNo);
        if (role.equalsIgnoreCase("engineer")){
            engineerRepository.save(new Engineer(ssn, employeeRepository.findByPerson_Ssn(ssn).get()));
        }else {
            salesManRepository.save(new SalesMan(ssn, employeeRepository.findByPerson_Ssn(ssn).get()));
        }
    }
}
