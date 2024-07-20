package com.avalanches.interfaceadapters.controllers;

import com.avalanches.applicationbusinessrules.usecases.ClienteUseCase;
import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.interfaceadapters.controllers.interfaces.ClienteControllerInterface;
import com.avalanches.interfaceadapters.gateways.ClienteGateway;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import com.avalanches.interfaceadapters.presenters.ClientePresenter;
import com.avalanches.interfaceadapters.presenters.dtos.ClienteDto;
import com.avalanches.interfaceadapters.presenters.interfaces.ClientePresenterInterface;
import org.springframework.jdbc.core.JdbcOperations;

public class ClienteController implements ClienteControllerInterface {

    @Override
    public void cadastrar(Cliente cliente, JdbcOperations jdbcOperations) {
        ClienteGatewayInterface clienteGateway = new ClienteGateway(jdbcOperations);
        ClienteUseCase.cadastrarCliente(cliente, clienteGateway);
    }

    @Override
    public ClienteDto consultar(String cpf, JdbcOperations jdbcOperations) {
        ClienteGatewayInterface clienteGateway = new ClienteGateway(jdbcOperations);
        Cliente cliente = ClienteUseCase.consultar(cpf, clienteGateway);

        ClientePresenterInterface clientePresenter = new ClientePresenter();
        return clientePresenter.clienteToDto(cliente);
    }

    @Override
    public void excluir(String cpf, JdbcOperations jdbcOperations) {
        ClienteGatewayInterface clienteGateway = new ClienteGateway(jdbcOperations);
        ClienteUseCase.excluir(cpf, clienteGateway);
    }
}
