package com.example.carsharing.controller;

import com.example.carsharing.dto.UserDTO;
import com.example.carsharing.entity.MyUser;
import com.example.carsharing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private final UserService userService;

    @GetMapping("/registry")
    public String registration(Model model) {
        return "registry";
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public ResponseEntity<MyUser> create(@RequestParam String email, @RequestParam String name,
                                         @RequestParam String password, Model model) {
        UserDTO dto = new UserDTO(name, password, email, "USER");
        return new ResponseEntity<>(userService.addUser(dto), HttpStatus.OK);
    }
}
