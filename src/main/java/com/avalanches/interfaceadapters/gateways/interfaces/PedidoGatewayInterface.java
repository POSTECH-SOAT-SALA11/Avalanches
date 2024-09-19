package com.avalanches.interfaceadapters.gateways.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;

import java.util.List;

public interface PedidoGatewayInterface {
    void cadastrar(Pedido pedido);

    void cadastrarProdutosPorPedido(Integer idPedido, PedidoProduto pedidoProduto);

    void atualizaStatus(Integer idPedido, StatusPedido statusPedido);

    List<Pedido> listar();

    boolean verificaPedidoExiste(Integer idPedido);

    String buscarStatusPedido(Integer idPedido);
}
