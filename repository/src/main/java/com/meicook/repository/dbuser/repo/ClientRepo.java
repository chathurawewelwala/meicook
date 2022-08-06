package com.meicook.repository.dbuser.repo;

import com.meicook.repository.dbuser.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientEntity,Long> {
}
