package com.advDB.carServiceCenter.resource.rest;


import com.advDB.carServiceCenter.model.Employee;
import com.advDB.carServiceCenter.resource.rest.request.EmployeeBody;
import com.advDB.carServiceCenter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/employee")
@RequestMapping(path = "/employee",
        produces = "application/xml")
@CrossOrigin(origins = "http://*")
public class EmployeeResource {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    @PostMapping(consumes = "application/*")
    public void insertEmployee(@RequestBody EmployeeBody employeeBody) {
        employeeService.insertEmployee(employeeBody.getSsn(), employeeBody.getBirthdate(), employeeBody.getEmail(),
                employeeBody.getFirstName(), employeeBody.getMiddleName(), employeeBody.getLastName(),
                employeeBody.getPhoneNo(), employeeBody.getSalary(), employeeBody.getCenterId(),
                employeeBody.getRole(), employeeBody.getSpecialization());
    }

    @GetMapping()
//    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
