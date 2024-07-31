package com.avalanches.interfaceadapters.presenters;

import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.interfaceadapters.presenters.dtos.ClienteDto;
import com.avalanches.interfaceadapters.presenters.interfaces.ClientePresenterInterface;

public class ClientePresenter implements ClientePresenterInterface {

    @Override
    public ClienteDto clienteToDto(Cliente cliente) {
        return new ClienteDto(cliente.id, cliente.nome, cliente.cpf, cliente.email);
    }
}
