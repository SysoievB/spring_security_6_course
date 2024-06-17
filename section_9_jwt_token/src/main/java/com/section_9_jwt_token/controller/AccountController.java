package com.section_9_jwt_token.controller;

import com.section_9_jwt_token.entity.Accounts;
import com.section_9_jwt_token.repo.AccountsRepository;
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
