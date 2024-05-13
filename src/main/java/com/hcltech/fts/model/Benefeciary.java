package com.hcltech.fts.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "beneficiary")
public class Benefeciary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String bId;

    private String beneficiaryName;

    //connect account to n beneficiaries
    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Account linkedAccount;

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public Account getLinkedAccount() {
        return linkedAccount;
    }

    public void setLinkedAccount(Account linkedAccount) {
        this.linkedAccount = linkedAccount;
    }
}
