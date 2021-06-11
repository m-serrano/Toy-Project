package com.toyprojectbackend.controller;

import com.toyprojectbackend.entity.Car;
import com.toyprojectbackend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CarController {
    
    @Autowired
    private CarRepository repository;

	@GetMapping("/cars")
	public ResponseEntity<Map<String, Object>> getCars(
			@RequestParam(required = false) String licensePlate,
			@RequestParam(required = false) String color,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size
	) {
		try {
			Pageable  paging = PageRequest.of(page, size);
			Page<Car> pagedCars = null;

			if (licensePlate == null && color == null)
				pagedCars = repository.findAll(paging);
			else if(licensePlate != null)
				pagedCars = repository.findByLicensePlate(licensePlate, paging);
			else if(color != null)
				pagedCars = repository.findByColor(color, paging);

			List<Car> cars = pagedCars.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("cars", cars);
			response.put("currentPage", pagedCars.getNumber());
			response.put("totalItems", pagedCars.getTotalElements());
			response.put("totalPages", pagedCars.getTotalPages());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

	@PostMapping("/cars")
	Car newCar(@RequestBody Car newCar) {
		return repository.save(newCar);
	}

	@DeleteMapping("/cars/{id}")
	void deleteCar(@PathVariable String id) {
		repository.deleteById(id);
	}
}