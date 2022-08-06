package com.meicook.service;

import com.meicook.repository.dbuser.model.AccountEntity;
import org.springframework.http.ResponseEntity;

public interface AccountService {
    ResponseEntity<AccountEntity> addDeposit(AccountEntity accountEntity);

    ResponseEntity<AccountEntity> withDrawDeposit(AccountEntity accountEntity);
}
