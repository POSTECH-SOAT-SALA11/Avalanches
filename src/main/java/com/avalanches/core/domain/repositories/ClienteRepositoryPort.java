package com.avalanches.core.domain.repositories;

import com.avalanches.core.domain.entities.Cliente;

public interface ClienteRepositoryPort {

    void cadastrar(Cliente cliente);

    Cliente identificar(String cpf);

    boolean verificaCpfExistente(String cpf);

    void deletar(String cpf);

}
