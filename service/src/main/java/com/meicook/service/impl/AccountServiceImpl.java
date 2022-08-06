package com.meicook.service.impl;

import com.meicook.repository.dbuser.model.AccountEntity;
import com.meicook.repository.dbuser.repo.AccountRepo;
import com.meicook.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Optional;

import static java.lang.Math.round;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public ResponseEntity<AccountEntity> addDeposit(AccountEntity accountEntity) {
        Optional<AccountEntity> accountOldRef = accountRepo.findById(accountEntity.getId());
        double currentBalance = accountOldRef.map(AccountEntity::getBalance).orElse(0.0);
        double newBalance = currentBalance + accountEntity.getBalance();
        accountEntity.setBalance(newBalance);
        accountRepo.save(accountEntity);
        return new ResponseEntity<>(accountEntity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AccountEntity> withDrawDeposit(AccountEntity accountEntity) {
        Optional<AccountEntity> accountOldRef = accountRepo.findById(accountEntity.getId());
        double currentBalance = accountOldRef.map(AccountEntity::getBalance).orElse(0.0);
        BigDecimal newBalance = BigDecimal.valueOf(currentBalance).subtract(BigDecimal.valueOf(accountEntity.getBalance()));
        accountEntity.setBalance(newBalance.doubleValue());
        accountRepo.save(accountEntity);
        return new ResponseEntity<>(accountEntity, HttpStatus.OK);
    }
}
