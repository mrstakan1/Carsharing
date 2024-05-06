package com.example.carsharing.controller;

import com.example.carsharing.dto.UserDTO;
import com.example.carsharing.entity.MyUser;
import com.example.carsharing.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SuperRegistrationController {

    private final UserService service;

    @RequestMapping(value = "/postman", method = RequestMethod.GET)
    public ResponseEntity<List<MyUser>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/postman", method = RequestMethod.POST)
    public ResponseEntity<MyUser> create(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(service.addUser(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/postman", method = RequestMethod.PUT)
    public ResponseEntity<MyUser> update(@RequestBody MyUser user) {
        return new ResponseEntity<>(service.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/postman/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        service.delete(id);
        return HttpStatus.OK;
    }
}
