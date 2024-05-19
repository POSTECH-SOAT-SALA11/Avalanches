package com.avalanches.adapter.driven.database.repository;

import com.avalanches.core.domain.ClienteNotFoundException;
import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.repositories.ClienteRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ClienteRepository implements ClienteRepositoryPort {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Cliente cliente) {
        jdbcTemplate.update("INSERT INTO cliente (nome, cpf, email) VALUES (?, ?, ?);",
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail());
    }

    @Override
    public Cliente identificar(String cpf) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM cliente WHERE cpf = ?",
                    new Object[]{cpf},
                    (rs, rowNum) -> new Cliente(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("email")
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNotFoundException(cpf);
        }
    }

    @Override
    public void deletar(String cpf) {
        try {
            int rowsAffected = jdbcTemplate.update("DELETE FROM cliente WHERE cpf = ?", cpf);
            if (rowsAffected == 0) {
                throw new ClienteNotFoundException(cpf);
            }
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNotFoundException(cpf);
        }
    }

}
