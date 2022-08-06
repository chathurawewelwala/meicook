package com.meicook.service;


import com.meicook.repository.dbuser.model.ClientEntity;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ClientService {

    ResponseEntity<ClientEntity> saveClient(ClientEntity clientEntity);

    Iterable<ClientEntity> findAll();

    Optional<ClientEntity> findbyId(Long id);
}
