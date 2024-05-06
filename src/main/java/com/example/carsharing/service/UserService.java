package com.example.carsharing.service;

import com.example.carsharing.dao.UserDAO;
import com.example.carsharing.dto.UserDTO;
import com.example.carsharing.entity.Car;
import com.example.carsharing.entity.MyUser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserDAO dao;
    private PasswordEncoder passwordEncoder;

    public MyUser addUser(UserDTO dto) {
        MyUser user = MyUser.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .roles(dto.getRoles())
                .build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return dao.save(user);
    }

    public List<MyUser> readAll() {
        return dao.findAll();
    }

    public MyUser update(MyUser user) {
        return dao.save(user);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }

    public MyUser book(Principal principal, Car car) {
        MyUser user = getUserByPrincipal(principal);
        user.setCar(car);
        return dao.save(user);
    }

    public MyUser getUserByPrincipal(Principal principal) {
        if (principal == null) return null;
        return dao.findByName(principal.getName()).get();
    }
}
