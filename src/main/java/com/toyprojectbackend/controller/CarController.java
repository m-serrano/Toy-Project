package com.toyprojectbackend.controller;

import java.util.List;

import com.toyprojectbackend.entity.Car;
import com.toyprojectbackend.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    
    @Autowired
    private CarRepository repository;
    
    @GetMapping("/car")
	public Car getCarPlate(@RequestParam(value = "licensePlate", defaultValue = "000") String licensePlate) {
		return repository.findByLicensePlate(licensePlate);
	}

    @GetMapping("/car")
	public List<Car> getCarColor(@RequestParam(value = "color", defaultValue = "000") String color) {
		return repository.findByColor(color);
	}

    @GetMapping("/car")
	public List<Car> getCars() {
		return repository.findAll();
	}

}