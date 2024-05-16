package com.advDB.carServiceCenter.resource.rest;


import com.advDB.carServiceCenter.service.CustomerService;
import com.advDB.carServiceCenter.resource.rest.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:8081")
public class CustomerResource {

    @Autowired
    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void insertCustomer(@RequestBody CustomerBody customerBody) {
        customerService.insertCustomer(customerBody.getSsn(), customerBody.getBirthdate(), customerBody.getEmail(),
                customerBody.getFirstName(), customerBody.getMiddleName(), customerBody.getLastName(),
                customerBody.getCity(), customerBody.getStreetNo(), customerBody.getBuildingNo(),
                customerBody.getDistrict(), customerBody.getPhoneNo());
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public void getAllCustomers() {
        customerService.getAllCustomers();
    }
}
