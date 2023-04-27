package com.cperez.crudjdbc.repository.impl;

import com.cperez.crudjdbc.dto.ClientDTO;
import com.cperez.crudjdbc.model.Client;
import com.cperez.crudjdbc.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Client> getClients() {
        //String sql = "SELECT * FROM CLIENT";
        String sql = "CALL getClients();";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public Client getClientById(int id) {
        //String sql = "SELECT * FROM CLIENT WHERE ID = ?";
        String sql = "CALL getClientById(?);";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        //Client client = new Client(clientDTO);
        //String sql = "INSERT INTO CLIENT (NAME, PHONE) VALUES (?,?) ";
        String sql = "CALL insertClient(?, ?);";
        jdbcTemplate.update(sql, clientDTO.getName(), clientDTO.getPhone());
        return clientDTO;
    }
}
