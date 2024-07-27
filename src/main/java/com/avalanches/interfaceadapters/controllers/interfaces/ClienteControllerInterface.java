package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.interfaceadapters.presenters.dtos.ClienteDto;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

public interface ClienteControllerInterface {
    void cadastrar(Cliente cliente, JdbcOperations jdbcOperations);

    ClienteDto consultar(String cpf, JdbcOperations jdbcOperations);

    void excluir(String cpf, JdbcOperations jdbcOperations);
}
