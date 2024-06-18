package com.section_10_method_level_security.controller;

import com.section_10_method_level_security.entity.AccountTransactions;
import com.section_10_method_level_security.repo.AccountTransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BalanceController {
    private final AccountTransactionsRepository repository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        return repository.findByCustomerIdOrderByTransactionDtDesc(id);
    }
}