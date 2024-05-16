package com.advDB.carServiceCenter.resource.rest;

import com.advDB.carServiceCenter.resource.rest.request.CarBody;
import com.advDB.carServiceCenter.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
@CrossOrigin(origins = "http://*")
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

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public void getAllCars() {
        carService.getAllCars();
    }
}
