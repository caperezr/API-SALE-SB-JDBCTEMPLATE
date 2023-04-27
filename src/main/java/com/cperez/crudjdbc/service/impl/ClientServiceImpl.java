package com.cperez.crudjdbc.service.impl;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.model.Client;
import com.cperez.crudjdbc.repository.ClientRepository;
import com.cperez.crudjdbc.repository.impl.ClientRepositoryImpl;
import com.cperez.crudjdbc.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    @Override
    public Client getClientById(int id) {
        return clientRepository.getClientById(id);
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        return clientRepository.createClient(clientDTO);
    }
}
