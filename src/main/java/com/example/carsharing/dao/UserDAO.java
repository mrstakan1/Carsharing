package com.example.carsharing.dao;

import com.example.carsharing.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByName(String username);
}
