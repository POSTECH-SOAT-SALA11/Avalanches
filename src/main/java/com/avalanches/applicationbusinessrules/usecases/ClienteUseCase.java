package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.frameworksanddrivers.databases.ClienteAlreadyExistsException;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase{

    public static void cadastrarCliente(Cliente cliente, ClienteGatewayInterface clienteGateway) {
        if(clienteGateway.verificaCpfExistente(cliente.cpf)) {
            throw new ClienteAlreadyExistsException(cliente.cpf);
        }
        clienteGateway.cadastrar(cliente);
    }

    public static Cliente consultar(String cpf, ClienteGatewayInterface clienteGateway) {
        return clienteGateway.identificar(cpf);
    }

    public static void excluir(String cpf, ClienteGatewayInterface clienteGateway) {
        clienteGateway.deletar(cpf);
    }

}
