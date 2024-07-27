package com.avalanches.interfaceadapters.presenters.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Cliente;
import com.avalanches.interfaceadapters.presenters.dtos.ClienteDto;

public interface ClientePresenterInterface {

    ClienteDto clienteToDto(Cliente cliente);

}
