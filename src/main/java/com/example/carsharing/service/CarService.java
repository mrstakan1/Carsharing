package com.example.carsharing.service;

import com.example.carsharing.dao.CarDAO;
import com.example.carsharing.dto.CarDTO;
import com.example.carsharing.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {
    private final CarDAO carDAO;

    public Car create(CarDTO dto) {
        Car product = Car.builder()
                .name(dto.getName())
                .mark(dto.getMark())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        return carDAO.save(product);
    }

    public List<Car> readAll() {
        return carDAO.findAll();
    }

    public Car update(Car car) {
        return carDAO.save(car);
    }

    public void delete(Long id) {
        carDAO.deleteById(id);
    }
}
