package com.example.carsharing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    private String name;
    private String mark;
    private String description;
    private Integer price;
}
