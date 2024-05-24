package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.repositories.ClienteRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase implements ClienteUseCasePort {

    @Inject
    ClienteRepositoryPort repository;

    @Override
    public void cadastrarCliente(Cliente cliente) {
        repository.cadastrar(cliente);
    }

    @Override
    public Cliente consultar(String cpf) {
        return repository.identificar(cpf);
    }

    @Override
    public void excluir(String cpf) {
        repository.deletar(cpf);
    }

}
