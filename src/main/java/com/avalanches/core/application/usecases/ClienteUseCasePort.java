package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteUseCasePort {

    void cadastrarCliente(Cliente cliente);

    Cliente consultar(String cpf);

    void excluir(String cpf);
}
