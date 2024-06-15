package com.section_7_authorization.controller;

import com.section_7_authorization.entity.Accounts;
import com.section_7_authorization.repo.AccountsRepository;
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
