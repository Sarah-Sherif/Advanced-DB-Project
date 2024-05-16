    package com.advDB.carServiceCenter.resource.rest;


    import com.advDB.carServiceCenter.model.Customer;
    import com.advDB.carServiceCenter.resource.rest.request.*;
    import com.advDB.carServiceCenter.service.CustomerService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
//    @RequestMapping("/customer")
    @RequestMapping(path = "/customer",
            produces = "application/xml")
    @CrossOrigin(origins = "http://*")
    public class CustomerResource {

        @Autowired
        private final CustomerService customerService;

        public CustomerResource(CustomerService customerService) {
            this.customerService = customerService;
        }

//        @PostMapping(produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
        @PostMapping(consumes = "application/*")
        public void insertCustomer(@RequestBody CustomerBody customerBody) {
            customerService.insertCustomer(customerBody.getSsn(), customerBody.getBirthdate(), customerBody.getEmail(),
                    customerBody.getFirstName(), customerBody.getMiddleName(), customerBody.getLastName(),
                    customerBody.getCity(), customerBody.getStreetNo(), customerBody.getBuildingNo(),
                    customerBody.getDistrict(), customerBody.getPhoneNo());
        }

        @GetMapping()
        public List<Customer> getAllCustomers() {
            return customerService.getAllCustomers();
        }
    }
