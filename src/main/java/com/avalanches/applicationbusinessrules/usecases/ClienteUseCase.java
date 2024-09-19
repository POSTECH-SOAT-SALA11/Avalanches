package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.applicationbusinessrules.usecases.interfaces.ClienteUseCaseInterface;
import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.frameworksanddrivers.databases.ClienteAlreadyExistsException;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;

public class ClienteUseCase implements ClienteUseCaseInterface {

    @Override
    public void cadastrarCliente(Cliente cliente, ClienteGatewayInterface clienteGateway) {
        if(clienteGateway.verificaCpfExistente(cliente.getCpf())) {
            throw new ClienteAlreadyExistsException(cliente.getCpf());
        }
        clienteGateway.cadastrar(cliente);
    }

    @Override
    public Cliente consultar(String cpf, ClienteGatewayInterface clienteGateway) {
        return clienteGateway.identificar(cpf);
    }

    @Override
    public void excluir(String cpf, ClienteGatewayInterface clienteGateway) {
        clienteGateway.deletar(cpf);
    }

}
