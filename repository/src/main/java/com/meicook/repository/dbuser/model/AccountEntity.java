package com.meicook.repository.dbuser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.meicook.repository.dbuser.Enum.Currency;
import common.AmountValidation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Account")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class AccountEntity {
    private static final long serialVersionUID = -2228784815938588107L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_number")
    @NotBlank(message = "account number is mandatory")
    private String account;

    @Column(name = "acc_balance")
    @AmountValidation (message = "Not a valid amount")
    @NotNull(message = "balance is mandatory")
    private double balance;

    @Column(name = "currency")
    @NotNull(message = "currency is mandatory")
    @Enumerated(EnumType.STRING)
    private Currency currency;
}
