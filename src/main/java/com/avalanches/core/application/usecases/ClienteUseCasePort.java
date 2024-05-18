package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteUseCasePort {

    void insertCustomer(Cliente cliente);

    Cliente identificar(String cpf);
}
