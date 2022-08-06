package com.meicook.service.impl;

import com.meicook.repository.dbuser.model.ClientEntity;
import com.meicook.repository.dbuser.repo.ClientRepo;
import com.meicook.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepo clientRepo;

    @Override
    public ResponseEntity<ClientEntity> saveClient(ClientEntity clientEntity) {
        ClientEntity clientEntity1 = clientRepo.save(ClientEntity.builder().
                fName(clientEntity.getFName()).lName(clientEntity.getLName()).account(clientEntity.getAccount()).build());
        return new ResponseEntity<>(clientEntity1, HttpStatus.OK);
    }

    @Override
    public Iterable<ClientEntity> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Optional<ClientEntity> findbyId(Long id) {
        return clientRepo.findById(id);
    }
}
