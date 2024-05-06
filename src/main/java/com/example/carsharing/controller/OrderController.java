package com.example.carsharing.controller;

import com.example.carsharing.entity.Car;
import com.example.carsharing.entity.MyUser;
import com.example.carsharing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class OrderController {
    private final UserService userService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String cart(@RequestParam(value="delName", required = false) String delName,
                       Model model, Principal principal) {
        MyUser user = userService.getUserByPrincipal(principal);
        if (user != null) {
            Car car = user.getCar();
            if (delName != null) {
                user.setCar(null);
                userService.update(user);
                car = null;
                model.addAttribute("car", car);
                return "order";
            }
            else {
                model.addAttribute("car", car);
            }
        }
        return "order";
    }
}
