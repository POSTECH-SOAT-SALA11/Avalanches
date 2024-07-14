package com.avalanches.interfaceadapters.controllers;

import com.avalanches.applicationbusinessrules.usecases.ClienteUseCase;
import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.interfaceadapters.controllers.interfaces.ClienteControllerInterface;
import com.avalanches.interfaceadapters.gateways.ClienteGateway;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

@Service
public class ClienteController implements ClienteControllerInterface {

    @Override
    public void cadastrar(Cliente cliente, JdbcOperations jdbcOperations) {
        ClienteGatewayInterface clienteGateway = new ClienteGateway(jdbcOperations);
        ClienteUseCase.cadastrarCliente(cliente, clienteGateway);
    }

    @Override
    public Cliente consultar(String cpf, JdbcOperations jdbcOperations) {
        ClienteGatewayInterface clienteGateway = new ClienteGateway(jdbcOperations);
        return ClienteUseCase.consultar(cpf, clienteGateway);
    }

    @Override
    public void excluir(String cpf, JdbcOperations jdbcOperations) {
        ClienteGatewayInterface clienteGateway = new ClienteGateway(jdbcOperations);
        ClienteUseCase.excluir(cpf, clienteGateway);
    }
}
