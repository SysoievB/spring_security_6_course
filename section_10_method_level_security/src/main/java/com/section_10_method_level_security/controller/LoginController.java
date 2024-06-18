package com.section_10_method_level_security.controller;

import com.section_10_method_level_security.entity.Customer;
import com.section_10_method_level_security.repo.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        return repository.findByEmail(authentication.getName());
    }
}