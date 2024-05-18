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
    public void insertCustomer(Cliente cliente) {
        repository.insert(cliente);
    }

    @Override
    public Cliente identificar(String cpf) {
        return repository.identificar(cpf);
    }


}
