package com.toyprojectbackend;

import com.toyprojectbackend.entity.Car;
import com.toyprojectbackend.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@ComponentScan (basePackageClasses = com.toyprojectbackend.config.AppConfig.class) 
public class ToyProjectBackendApplication implements CommandLineRunner{
	@Autowired
	private CarRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ToyProjectBackendApplication.class, args);
	}

	@Override
	public void run(String ... args) throws Exception {
  
	  repository.deleteAll();
	
	  // save a couple of cars
	  repository.save(Car.builder().color("blue").licensePlate("ADX001").build());
	  repository.save(Car.builder().color("red").licensePlate("ADX002").build());
  
	  // fetch all cars
	  System.out.println("Cars found with findAll():");
	  System.out.println("-------------------------------");
	  for (Car customer : repository.findAll()) {
		System.out.println(customer);
	  }
	  System.out.println();
	}

}
