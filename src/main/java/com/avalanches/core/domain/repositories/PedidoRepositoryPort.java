package com.avalanches.core.domain.repositories;

import com.avalanches.core.domain.entities.Pedido;
import com.avalanches.core.domain.entities.PedidoProduto;

public interface PedidoRepositoryPort {
    void cadastrar(Pedido pedido);

    void cadastrarProdutosPorPedido(Integer idPedido, PedidoProduto pedidoProduto);
}
