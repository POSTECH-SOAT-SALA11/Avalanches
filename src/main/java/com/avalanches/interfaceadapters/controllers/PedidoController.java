package com.avalanches.interfaceadapters.controllers;

import com.avalanches.applicationbusinessrules.usecases.PedidoUseCase;
import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.interfaceadapters.controllers.interfaces.PedidoControllerInterface;
import com.avalanches.interfaceadapters.gateways.PedidoGateway;
import com.avalanches.interfaceadapters.gateways.interfaces.PedidoGatewayInterface;
import com.avalanches.interfaceadapters.presenters.PedidoPresenter;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import com.avalanches.interfaceadapters.presenters.interfaces.PedidoPresenterInterface;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public class PedidoController implements PedidoControllerInterface {

    @Override
    public Integer cadastrar(Pedido pedido, JdbcOperations jdbcOperations) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        return PedidoUseCase.cadastrar(pedido, pedidoGateway);
    }

    @Override
    public void atualizaStatus(Integer idPedido, StatusPedido statusPedido, JdbcOperations jdbcOperations) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        PedidoUseCase.atualizaStatus(idPedido, statusPedido, pedidoGateway);
    }

    @Override
    public List<PedidoDto> listar(JdbcOperations jdbcOperations) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        List<Pedido> pedidos = PedidoUseCase.listar(pedidoGateway);
        PedidoPresenterInterface pedidoPresenter = new PedidoPresenter();
        return pedidoPresenter.pedidosToDtos(pedidos);
    }
}
