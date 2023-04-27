package com.cperez.crudjdbc.repository;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.model.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @Transactional
    @Rollback
    public void testCreateClient() {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Prueba 4");
        clientDTO.setPhone("555-1234 10");
        ClientDTO result = clientRepository.createClient(clientDTO);
        assertNotNull(result);
        assertEquals(clientDTO, result);
    }

    @Test
    @Transactional
    @Rollback
    public void testGetClients() {
        List<Client> clients = clientRepository.getClients();
        assertNotNull(clients);
        assertEquals(22, clients.size());
    }

    @Test
    @Transactional
    @Rollback
    public void testGetClientById() {
        Client clientPrueba = new Client(1, "Agregado 1", "989787654");
        Client clientActual = clientRepository.getClientById(1);
        assertNotNull(clientActual);
        assertEquals(clientPrueba.getId(), clientActual.getId());
        assertEquals(clientPrueba.getName(), clientActual.getName());
        assertEquals(clientPrueba.getPhone(), clientActual.getPhone());
    }

}
