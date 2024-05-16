package com.advDB.carServiceCenter.resource.rest;


import com.advDB.carServiceCenter.resource.rest.request.EmployeeBody;
import com.advDB.carServiceCenter.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://*")
public class EmployeeResource {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void insertEmployee(@RequestBody EmployeeBody employeeBody) {
        employeeService.insertEmployee(employeeBody.getSsn(), employeeBody.getBirthdate(), employeeBody.getEmail(),
                employeeBody.getFirstName(), employeeBody.getMiddleName(), employeeBody.getLastName(),
                employeeBody.getPhoneNo(), employeeBody.getSalary(), employeeBody.getCenterId(),
                employeeBody.getRole(), employeeBody.getSpecialization());
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public void getAllEmployees() {
        employeeService.getAllEmployees();
    }

}
