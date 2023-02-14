package com.example.walletservice.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WalletDto {

    private Long id;
    private String reference;
    private LocalDate created_at;
    private Double balance;
    private String cin_user;

    public WalletDto(String reference, LocalDate created_at, Double balance, String cin_user) {
        this.reference=reference;
        this.created_at=created_at;
        this.balance=balance;
        this.cin_user=cin_user;
    }
}
