package com.hcltech.fts.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String accountNo;

    private String customerName;

    private BigDecimal accountBalance;

    @OneToMany(mappedBy = "linkedAccount")
    private Set<Benefeciary> linkedBenefeciaries;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Set<Benefeciary> getLinkedBenefeciaries() {
        return linkedBenefeciaries;
    }

    public void setLinkedBenefeciaries(Set<Benefeciary> linkedBenefeciaries) {
        this.linkedBenefeciaries = linkedBenefeciaries;
    }
}
