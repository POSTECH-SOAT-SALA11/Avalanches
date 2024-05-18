package com.avalanches.adapter.driver;

import com.avalanches.adapter.driver.dto.ClienteRequest;
import com.avalanches.adapter.driver.dto.ClienteResponse;
import com.avalanches.adapter.driver.dto.CreateProdutoRequest;
import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.entities.Produto;

public class Convert {

    public static Cliente clienteRequestToCliente(ClienteRequest request) {
        return new Cliente(request.nome(), request.cpf(), request.email());
    }

    public static ClienteResponse clienteToClienteResponse(Cliente cliente){
        return new ClienteResponse(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
    }

    public static Produto createProdutoRequestToProduto(CreateProdutoRequest request) {
        return new Produto(
            request.valor(),
            request.quantidade(),
            request.categoria(),
            request.nome(),
            request.descricao(),
            null
        );
    }
}
