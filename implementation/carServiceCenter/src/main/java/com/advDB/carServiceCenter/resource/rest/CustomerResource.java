package com.advDB.carServiceCenter.resource.rest;


import com.advDB.carServiceCenter.service.CustomerService;
import com.advDB.carServiceCenter.resource.rest.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
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
}