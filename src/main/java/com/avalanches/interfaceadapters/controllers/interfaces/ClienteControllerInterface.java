package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Cliente;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

@Service
public interface ClienteControllerInterface {
    void cadastrar(Cliente cliente, JdbcOperations jdbcOperations);

    Cliente consultar(String cpf, JdbcOperations jdbcOperations);

    void excluir(String cpf, JdbcOperations jdbcOperations);
}
