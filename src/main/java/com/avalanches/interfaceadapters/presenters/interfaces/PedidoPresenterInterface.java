package com.avalanches.interfaceadapters.presenters.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoProdutoDto;
import com.avalanches.interfaceadapters.presenters.dtos.StatusPedidoDto;
import java.util.List;

public interface PedidoPresenterInterface {

    List<PedidoDto> pedidosToDtos(List<Pedido> pedidos);

    PedidoDto pedidoToDto(Pedido pedido);

    List<PedidoProdutoDto> pedidoProdutosToDtos(List<PedidoProduto> pedidoProdutos);

    PedidoProdutoDto pedidoProdutoToDto(PedidoProduto pedidoProduto);

    StatusPedidoDto statusPedidoToDto(StatusPedido statusPedido);

}
