package com.cperez.crudjdbc.controller;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.model.Client;
import com.cperez.crudjdbc.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@Slf4j
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getClients() {
        try {
            List<Client> clients = clientService.getClients();
            return ResponseEntity.status(HttpStatus.OK).body(clients);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientsById(@PathVariable int id) {
        try {
            Client client = clientService.getClientById(id);
            return ResponseEntity.status(HttpStatus.OK).body(client);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/clients")
    @Transactional
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        try {
            ClientDTO clientSave = clientService.createClient(clientDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(clientSave);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}
