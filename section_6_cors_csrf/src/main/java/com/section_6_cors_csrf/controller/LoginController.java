package com.section_6_cors_csrf.controller;

import com.section_6_cors_csrf.entity.Customer;
import com.section_6_cors_csrf.repo.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class LoginController {
    private final CustomerJpaRepository repository;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        return Optional.of(encoder.encode(customer.getPwd()))
                .map(customer::setEncodedPassword)
                .map(repository::save)
                .filter(savedCustomer -> savedCustomer.getId() > 0)
                .map(savedCustomer -> ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered"))
                .orElse(ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("An exception occurred"));
    }
}