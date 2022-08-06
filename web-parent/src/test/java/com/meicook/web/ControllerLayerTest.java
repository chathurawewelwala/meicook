package com.meicook.web;


import com.meicook.repository.dbuser.model.ClientEntity;
import com.meicook.repository.dbuser.repo.ClientRepo;
import com.meicook.service.ClientService;
import com.meicook.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerLayerTest {

//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void getHello() throws Exception {
//
//        ResponseEntity<String> response = restTemplate.getForEntity(
//                new URL("http://localhost:" + port + "/").toString(), String.class);
//        assertEquals("Hello Controller", response.getBody());
//
//    }

    @MockBean
    private ClientRepo clientRepo;
    @Autowired
    ClientService clientService;

    @BeforeEach
    void setMockRepositoryOutput() {
        List<ClientEntity> list = new ArrayList<ClientEntity>();
        list.add(ClientEntity.builder().fName("chathura").lName("wewelwala").build());
        when(clientRepo.findAll()).thenReturn(list);
    }

    @DisplayName("MeiCook testing Mockito environment and spring @Autowired integration")
    @Test
    void testGet() {
        List<ClientEntity> list = new ArrayList<ClientEntity>();
        list.add(ClientEntity.builder().fName("chathura").lName("wewelwala").build());
        assertEquals(list, clientService.findAll());
    }
}
