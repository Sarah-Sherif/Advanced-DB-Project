package com.advDB.carServiceCenter.service.impl;

import com.advDB.carServiceCenter.model.ServiceCenter;
import com.advDB.carServiceCenter.model.repositories.EmployeeRepository;
import com.advDB.carServiceCenter.model.repositories.PersonRepository;
import com.advDB.carServiceCenter.model.repositories.ServiceCenterRepository;
import com.advDB.carServiceCenter.service.ServiceCenterService;
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
    public void insertServiceCenter(String city, Integer streetNo, Integer buildingNo, String district, Long managerSSN) {
        if (personRepository.findBySsn(managerSSN).isEmpty()) {
            throw new IllegalArgumentException("Manager with SSN " + managerSSN + " does not exist");
        }

        serviceCenterRepository.save(new ServiceCenter(city, district, streetNo, buildingNo, employeeRepository.findBySsn(managerSSN).get()));
    }


}
