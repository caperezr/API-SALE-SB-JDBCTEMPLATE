package com.cperez.crudjdbc.repository;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository {
    public List<Client> getClients();
    public Client getClientById (int id);
    public ClientDTO createClient (ClientDTO clientDTO);
}
