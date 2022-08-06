package com.meicook.repository.dbuser.repo;

import com.meicook.repository.dbuser.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<AccountEntity,Long> {
}
