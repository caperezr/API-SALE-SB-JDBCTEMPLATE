package com.cperez.crudjdbc.service;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.model.Client;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    public List<Client> getClients();
    public Client getClientById (int id);
    public ClientDTO createClient (ClientDTO clientDTO);
}
