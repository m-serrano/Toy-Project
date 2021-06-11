package com.toyprojectbackend.repository;

import java.util.List;
import com.toyprojectbackend.entity.Car;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
  public Car findByLicensePlate(String value);
  public List<Car> findByColor(String value);
}
