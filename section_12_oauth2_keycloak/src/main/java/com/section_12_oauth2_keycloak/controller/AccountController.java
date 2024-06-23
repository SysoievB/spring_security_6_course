package com.section_12_oauth2_keycloak.controller;

import com.section_12_oauth2_keycloak.entity.Accounts;
import com.section_12_oauth2_keycloak.repo.AccountsRepository;
import com.section_12_oauth2_keycloak.repo.CustomerJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class AccountController {
    private final AccountsRepository repository;
    private final CustomerJpaRepository customerJpaRepository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam String email) {
        return Optional.of(customerJpaRepository.findByEmail(email))
                .map(customer -> repository.findByCustomerId(customer.getId()))
                .orElse(null);
    }
}
