package com.avalanches.interfaceadapters.gateways.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;

import java.util.List;

public interface PedidoGatewayInterface {
    void cadastrar(Pedido pedido);

    void cadastrarProdutosPorPedido(Integer idPedido, PedidoProduto pedidoProduto);

    List<Pedido> listar();
}
