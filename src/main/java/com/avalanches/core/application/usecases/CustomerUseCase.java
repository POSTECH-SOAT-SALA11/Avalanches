package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.utils.EncryptionUtils;
import com.avalanches.core.domain.repositories.ClienteRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class CustomerUseCase implements CustomerUseCasePort {

    @Inject
    ClienteRepositoryPort repository;

    @Override
    public void insertCustomer(Cliente cliente) {
        // cliente.setCpf(EncryptionUtils.encrypt(cliente.getCpf()));
        repository.insert(cliente);
    }

}
