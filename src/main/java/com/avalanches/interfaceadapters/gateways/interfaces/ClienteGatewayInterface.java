package com.avalanches.interfaceadapters.gateways.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Cliente;

public interface ClienteGatewayInterface {

    void cadastrar(Cliente cliente);

    Cliente identificar(String cpf);

    boolean verificaClienteExiste(Integer idCliente);

    boolean verificaCpfExistente(String cpf);

    void deletar(String cpf);

}
