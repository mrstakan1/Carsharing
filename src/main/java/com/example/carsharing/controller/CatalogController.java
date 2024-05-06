package com.example.carsharing.controller;

import com.example.carsharing.entity.Car;
import com.example.carsharing.service.CarService;
import com.example.carsharing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class CatalogController {
    private final CarService carService;
    private final UserService userService;

    @GetMapping("/catalog")
    public String menu(@RequestParam(value="orderName", required = false) String orderName,
                       Principal principal, Model model) {
        List<Car> cars = carService.readAll();
        model.addAttribute("cars", cars);
        if (orderName != null && userService.getUserByPrincipal(principal) != null) {
            Car car = findCarByName(orderName, cars);
            userService.book(principal, car);
        }
        return "catalog";
    }

    public Car findCarByName(String name, List<Car> list) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getName().equals(name))
                return list.get(i);
        }
        return null;
    }
}
