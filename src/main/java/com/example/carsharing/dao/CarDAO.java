package com.example.carsharing.dao;

import com.example.carsharing.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDAO extends JpaRepository<Car, Long> {
    
}
