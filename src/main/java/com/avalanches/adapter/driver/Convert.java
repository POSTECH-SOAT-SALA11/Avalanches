package com.avalanches.adapter.driver;

import com.avalanches.adapter.driver.dto.ClienteRequest;
import com.avalanches.core.domain.entities.Cliente;

public class Convert {

    public static Cliente customerRequestToCustomer(ClienteRequest request) {
        return new Cliente(request.nome(), request.cpf(), request.email());
    }
}
