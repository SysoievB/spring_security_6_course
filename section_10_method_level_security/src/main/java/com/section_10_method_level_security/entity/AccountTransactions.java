package com.section_10_method_level_security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="account_transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountTransactions {

    @Id
    private String transactionId;
    private long accountNumber;
    private int customerId;
    private Date transactionDt;
    private String transactionSummary;
    private String transactionType;
    private int transactionAmt;
    private int closingBalance;
    private String createDt;
}
