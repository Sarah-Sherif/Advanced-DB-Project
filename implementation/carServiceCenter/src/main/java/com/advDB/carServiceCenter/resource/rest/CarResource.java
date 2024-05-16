package com.advDB.carServiceCenter.resource.rest;

import com.advDB.carServiceCenter.resource.rest.request.CarBody;
import com.advDB.carServiceCenter.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarResource {

    @Autowired
    private final CarService carService;

    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public void insertCar(@RequestBody CarBody carBody) {
        carService.insertCar(carBody.getPlateNo(), carBody.getModelName(), carBody.getModelYear(), carBody.getBrand(), carBody.getSsn());
    }
}