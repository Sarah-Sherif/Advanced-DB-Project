package com.advDB.carServiceCenter.resource.rest;

import com.advDB.carServiceCenter.model.Car;
import com.advDB.carServiceCenter.resource.rest.request.CarBody;
import com.advDB.carServiceCenter.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/car")
@RequestMapping(path = "/car",
        produces = "application/xml")
@CrossOrigin(origins = "http://*")
public class CarResource {

    @Autowired
    private final CarService carService;

    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public void insertCar(@RequestBody CarBody carBody) {
        carService.insertCar(carBody.getPlateNo(), carBody.getModelName(), carBody.getModelYear(), carBody.getBrand(), carBody.getSsn());
    }

    @GetMapping()
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
}
