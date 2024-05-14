package com.nuggets.advDB.service.impl;

import com.nuggets.advDB.model.ServiceCenter;
import com.nuggets.advDB.model.repository.EmployeeRepository;
import com.nuggets.advDB.model.repository.PersonRepository;
import com.nuggets.advDB.model.repository.ServiceCenterRepository;
import com.nuggets.advDB.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCenterServiceImpl implements ServiceCenterService {

    @Autowired
    private final ServiceCenterRepository serviceCenterRepository;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final EmployeeRepository employeeRepository;

    public ServiceCenterServiceImpl(ServiceCenterRepository serviceCenterRepository, PersonRepository personRepository, EmployeeRepository employeeRepository) {
        this.serviceCenterRepository = serviceCenterRepository;
        this.personRepository = personRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void insertServiceCenter(String city, Integer streetNo, Long buildingNo, String district, String managerSSN) {
        if (personRepository.findBySsn(managerSSN).isEmpty()) {
            throw new IllegalArgumentException("Manager with SSN " + managerSSN + " does not exist");
        }

        serviceCenterRepository.save(new ServiceCenter(city, streetNo, buildingNo, district, employeeRepository.findByPerson_Ssn(managerSSN).get()));
    }

    @Override
    public void incrementServiceCenterNoOfEmployees(Long centerID) {
        ServiceCenter serviceCenter = serviceCenterRepository.findById(centerID).get();
        serviceCenter.setNoOfEmployees(serviceCenter.getNoOfEmployees() + 1);
        serviceCenterRepository.save(serviceCenter);
    }
}
