package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Pedido;
import com.avalanches.core.domain.entities.PedidoProduto;
import com.avalanches.core.domain.repositories.PedidoRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoUseCase implements PedidoUseCasePort {

    @Inject
    PedidoRepositoryPort pedidoRepositoryPort;

    @Override
    public Integer cadastrar(Pedido pedido) {
        pedidoRepositoryPort.cadastrar(pedido);

        for(PedidoProduto p: pedido.listaProduto)
            pedidoRepositoryPort.cadastrarProdutosPorPedido(pedido.id, p);

        return pedido.id;
    }


    @Override
    public List<Pedido> listar() {
        return pedidoRepositoryPort.listar();
    }

}
