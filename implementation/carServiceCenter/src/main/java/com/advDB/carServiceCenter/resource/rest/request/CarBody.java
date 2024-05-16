package com.advDB.carServiceCenter.resource.rest.request;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Getter
@Setter
public class CarBody {

// void insertCar(String plateNo, String modelName, Integer modelYear, String brand, Long ssn);
    private String plateNo;
    private String modelName;
    private Integer modelYear;
    private String brand;
    private Long ssn;
}
