package com.toyprojectbackend.repository;

import java.util.List;
import com.toyprojectbackend.entity.Car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {
  public Page<Car> findByLicensePlate(String value, Pageable pageable);
  public Page<Car> findByColor(String value, Pageable pageable);
}