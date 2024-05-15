package com.avalanches.adapter.driven.database.repository;

import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.repositories.ClienteRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepository implements ClienteRepositoryPort {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Cliente cliente) {

        System.out.println(cliente.getCpf());

        jdbcTemplate.update("INSERT INTO cliente (id, nome, cpf, email) VALUES (?, ?, ?, ?);",
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail());
    }


}
