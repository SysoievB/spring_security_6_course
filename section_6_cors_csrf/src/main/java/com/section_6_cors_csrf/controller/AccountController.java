package com.section_6_cors_csrf.controller;

import com.section_6_cors_csrf.entity.Accounts;
import com.section_6_cors_csrf.repo.AccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {
    private final AccountsRepository repository;

    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam int id) {
        return repository.findByCustomerId(id);
    }
}
