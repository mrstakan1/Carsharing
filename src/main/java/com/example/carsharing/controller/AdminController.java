package com.example.carsharing.controller;

import com.example.carsharing.dto.CarDTO;
import com.example.carsharing.entity.Car;
import com.example.carsharing.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@AllArgsConstructor
public class AdminController {
    private final CarService carService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String addMenu(@RequestParam(value="idName", required = false) String idName, Model model) {
        List<Car> positions = carService.readAll();
        if (idName == null) {
            String carId = "Нет названия - нет ID";
            model.addAttribute("carId", carId);
        }
        else {
            long carId = findIdByName(idName, positions);
            if (carId == -1) {
                model.addAttribute("carId", "Нет такой машины");
            }
            else {
                model.addAttribute("carID", "ID машины: " + carId);
            }
        }
        return "admin";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ResponseEntity<Car> create(@RequestParam String name, @RequestParam String mark,
                                      @RequestParam String description, @RequestParam Integer price,
                                      Model model) {
        CarDTO dto = new CarDTO(name, mark, description, price);
        return new ResponseEntity<>(carService.create(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/admin", method = RequestMethod.DELETE)
    public void delete(@RequestParam Long delId, Model model) {
        carService.delete(delId);
    }

    public long findIdByName(String name, List<Car> list) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getName().equals(name))
                return list.get(i).getId();
        }
        return -1;
    }
}
