package com.meicook.web.controller;


import com.meicook.repository.dbuser.model.AccountEntity;
import com.meicook.repository.dbuser.model.ClientEntity;
import com.meicook.service.AccountService;
import com.meicook.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController()
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @Autowired
    AccountService accountService;

    @PostMapping("/addClient")
    public ResponseEntity<ClientEntity> addClient(@Valid @RequestBody ClientEntity clientEntity) {
        return clientService.saveClient(clientEntity);
    }

    @PostMapping("/addDeposit")
    public ResponseEntity<AccountEntity> addDeposit(@Valid @RequestBody AccountEntity accountEntity) {
        return accountService.addDeposit(accountEntity);
    }

    @PostMapping("/withDrawDeposit")
    public ResponseEntity<AccountEntity> withDrawDeposit(@Valid @RequestBody AccountEntity accountEntity) {
        return accountService.withDrawDeposit(accountEntity);
    }

    @QueryMapping
    public Iterable<ClientEntity> getAllClient(){
        return clientService.findAll();
    }

    @QueryMapping
    public Optional<ClientEntity> getClient(@Argument Long id){
        return clientService.findbyId(id);
    }
}
