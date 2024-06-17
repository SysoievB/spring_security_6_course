package com.section_9_jwt_token.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Accounts {

    private int customerId;
    @Id
    private long accountNumber;
    private String accountType;
    private String branchAddress;
    private String createDt;
}
