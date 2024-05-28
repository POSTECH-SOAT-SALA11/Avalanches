package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.ClienteAlreadyExistsException;
import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.repositories.ClienteRepositoryPort;
import jakarta.inject.Inject;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class ClienteUseCase implements ClienteUseCasePort {

    @Inject
    ClienteRepositoryPort repository;

    @Override
    public void cadastrarCliente(Cliente cliente) {
        if(repository.verificaCpfExistente(cliente.cpf)) {
            throw new ClienteAlreadyExistsException(cliente.cpf);
        }
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
