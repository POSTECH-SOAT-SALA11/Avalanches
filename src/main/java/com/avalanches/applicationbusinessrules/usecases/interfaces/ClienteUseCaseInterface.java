package com.avalanches.applicationbusinessrules.usecases.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteUseCaseInterface {

    void cadastrarCliente(Cliente cliente);

    Cliente consultar(String cpf);

    void excluir(String cpf);
}
