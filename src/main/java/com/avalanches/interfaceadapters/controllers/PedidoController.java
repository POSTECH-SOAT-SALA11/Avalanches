package com.avalanches.interfaceadapters.controllers;

import com.avalanches.applicationbusinessrules.usecases.PedidoUseCase;
import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.frameworksanddrivers.api.dto.WebHookMockParams;
import com.avalanches.interfaceadapters.controllers.interfaces.PedidoControllerInterface;
import com.avalanches.interfaceadapters.gateways.ClienteGateway;
import com.avalanches.interfaceadapters.gateways.PagamentoGateway;
import com.avalanches.interfaceadapters.gateways.PedidoGateway;
import com.avalanches.interfaceadapters.gateways.ProdutoGateway;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PedidoGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import com.avalanches.interfaceadapters.presenters.PedidoPresenter;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import com.avalanches.interfaceadapters.presenters.interfaces.PedidoPresenterInterface;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public class PedidoController implements PedidoControllerInterface {

    @Override
    public Integer cadastrar(Pedido pedido, JdbcOperations jdbcOperations, WebHookMockParams webHookMockParams) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        ProdutoGatewayInterface produtoGateway = new ProdutoGateway(jdbcOperations);
        PagamentoGatewayInterface pagamentoGateway = new PagamentoGateway(jdbcOperations, webHookMockParams);
        ClienteGatewayInterface clienteGateway = new ClienteGateway(jdbcOperations);
        PedidoUseCase pedidoUseCase = new PedidoUseCase();
        return pedidoUseCase.cadastrar(pedido, pedidoGateway, produtoGateway, pagamentoGateway, clienteGateway);
    }

    @Override
    public void atualizaStatus(Integer idPedido, StatusPedido statusPedido, JdbcOperations jdbcOperations) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        PedidoUseCase pedidoUseCase = new PedidoUseCase();
        pedidoUseCase.atualizaStatus(idPedido, statusPedido, pedidoGateway);
    }

    @Override
    public List<PedidoDto> listar(JdbcOperations jdbcOperations) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        PedidoUseCase pedidoUseCase = new PedidoUseCase();
        List<Pedido> pedidos = pedidoUseCase.listar(pedidoGateway);
        PedidoPresenterInterface pedidoPresenter = new PedidoPresenter();
        return pedidoPresenter.pedidosToDtos(pedidos);
    }
}
