package com.advDB.carServiceCenter.resource.rest.request;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Getter
@Setter
public class EmployeeBody {
//    public void insertEmployee(Long ssn, String birthdate, String email, String firstName, String middleName,
//                                  String lastName, String phoneNo, Double salary, Integer centerId, String role, String specialization);
    private Long ssn;
    private String birthdate;
    private String email;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNo;
    private Double salary;
    private Integer centerId;
    private String role;
    private String specialization;

}
