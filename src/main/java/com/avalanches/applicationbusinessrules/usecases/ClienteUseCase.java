package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.applicationbusinessrules.usecases.interfaces.ClienteUseCaseInterface;
import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.frameworksanddrivers.databases.ClienteAlreadyExistsException;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase implements ClienteUseCaseInterface {

    @Inject
    ClienteGatewayInterface gateway;

    @Override
    public void cadastrarCliente(Cliente cliente) {
        if(gateway.verificaCpfExistente(cliente.cpf)) {
            throw new ClienteAlreadyExistsException(cliente.cpf);
        }
        gateway.cadastrar(cliente);
    }

    @Override
    public Cliente consultar(String cpf) {
        return gateway.identificar(cpf);
    }

    @Override
    public void excluir(String cpf) {
        gateway.deletar(cpf);
    }

}
