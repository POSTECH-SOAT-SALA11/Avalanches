package com.avalanches.interfaceadapters.presenters;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoProdutoDto;
import com.avalanches.interfaceadapters.presenters.dtos.StatusPedidoDto;
import com.avalanches.interfaceadapters.presenters.interfaces.PedidoPresenterInterface;

import java.util.ArrayList;
import java.util.List;

public class PedidoPresenter implements PedidoPresenterInterface {

    @Override
    public List<PedidoDto> pedidosToDtos(List<Pedido> pedidos) {
        List<PedidoDto> pedidoDtos;
        if (pedidos != null) {
            pedidoDtos = pedidos
                    .stream()
                    .map(this::pedidoToDto)
                    .toList();
        } else {
            pedidoDtos = new ArrayList<>();
        }
        return pedidoDtos;
    }

    @Override
    public PedidoDto pedidoToDto(Pedido pedido) {
        return new PedidoDto(
            pedido.getId(),
            statusPedidoToDto(pedido.getStatus()),
            pedido.getValor(),
            pedido.getDataCriacao(),
            pedido.getDataFinalizacao(),
            pedido.getTempoEspera(),
            pedidoProdutosToDtos(pedido.getListaProduto()),
            pedido.getIdCliente()
        );
    }

    @Override
    public List<PedidoProdutoDto> pedidoProdutosToDtos(List<PedidoProduto> pedidoProdutos) {
        List<PedidoProdutoDto> pedidoProdutoDtos;
        if (pedidoProdutos != null) {
            pedidoProdutoDtos = pedidoProdutos
                    .stream()
                    .map(this::pedidoProdutoToDto)
                    .toList();
        } else {
            pedidoProdutoDtos = new ArrayList<>();
        }
        return pedidoProdutoDtos;
    }

    @Override
    public PedidoProdutoDto pedidoProdutoToDto(PedidoProduto pedidoProduto) {
        return new PedidoProdutoDto(
            pedidoProduto.getIdProduto(),
            pedidoProduto.getQuantidade(),
            pedidoProduto.getValorUnitario()
        );
    }

    @Override
    public StatusPedidoDto statusPedidoToDto(StatusPedido statusPedido) {
        return StatusPedidoDto.valueOf(statusPedido.name());
    }
}
