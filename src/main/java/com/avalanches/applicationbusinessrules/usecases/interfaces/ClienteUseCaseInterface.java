package com.avalanches.applicationbusinessrules.usecases.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import org.springframework.stereotype.Service;

@Service
public interface ClienteUseCaseInterface {

    void cadastrarCliente(Cliente cliente, ClienteGatewayInterface clienteGateway);

    Cliente consultar(String cpf, ClienteGatewayInterface clienteGateway);

    void excluir(String cpf, ClienteGatewayInterface clienteGateway);

}
