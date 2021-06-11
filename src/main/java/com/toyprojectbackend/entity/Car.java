package com.toyprojectbackend.entity;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Car {
    @Id
    private String id;
  
    private String licensePlate;
    private String color;  
    
    @Override
    public String toString() {
      return String.format(
        "Customer[id=%s, placa='%s', color='%s']",
        id, getLicensePlate(), getColor());

  }

  @Builder
  public Car(String licensePlate, String color){
    this.licensePlate = licensePlate;
    this.color = color; 
  }

}