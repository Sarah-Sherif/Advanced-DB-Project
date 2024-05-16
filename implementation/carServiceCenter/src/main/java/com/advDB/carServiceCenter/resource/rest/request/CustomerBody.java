package com.advDB.carServiceCenter.resource.rest.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

//@XmlRootElement
@Getter
@Setter
public class CustomerBody {
//     public void insertCustomer(Long ssn, String birthdate, String email, String firstName, String middleName,
//                                String lastName, String city, Integer streetNo, Integer buildingNo, String district, String phoneNo);
    private Long ssn;
    private LocalDate birthdate;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String city;
    private Integer streetNo;
    private Integer buildingNo;
    private String district;
    private String phoneNo;
}
