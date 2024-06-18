package com.section_10_method_level_security.controller;

import com.section_10_method_level_security.entity.Loans;
import com.section_10_method_level_security.repo.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class LoansController {
    private final LoanRepository loanRepository;

    @GetMapping("/myLoans")
    @PreAuthorize("hasRole('USER')")
    public List<Loans> getLoanDetails(@RequestParam int id) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }
}