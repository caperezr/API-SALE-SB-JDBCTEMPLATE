package com.cperez.crudjdbc.clientservicetest;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.model.Client;
import com.cperez.crudjdbc.repository.ClientRepository;
import com.cperez.crudjdbc.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientServiceTest {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*public void setUp() {
        MockitoAnnotations.initMocks(this);
    }*/


    @Test
    public void testGetClients() {
        ClientService clientService = mock(ClientService.class);
        when(clientService.getClients()).thenReturn(Arrays.asList(new Client(1, "Cristhian", "989878767"), new Client(2, "Sebastian", "989878767")));
        List<Client> result = clientService.getClients();
        assertEquals(2, result.size());
        assertEquals("Cristhian", result.get(0).getName());
        assertEquals("989878767", result.get(0).getPhone());
        assertEquals("Sebastian", result.get(1).getName());
        assertEquals("989878767", result.get(1).getPhone());
    }

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








}
