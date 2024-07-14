package com.avalanches.interfaceadapters.controllers;

import com.avalanches.applicationbusinessrules.usecases.PedidoUseCase;
import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.interfaceadapters.controllers.interfaces.PedidoControllerInterface;
import com.avalanches.interfaceadapters.gateways.PedidoGateway;
import com.avalanches.interfaceadapters.gateways.interfaces.PedidoGatewayInterface;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;

public class PedidoController implements PedidoControllerInterface {

    @Override
    public Integer cadastrar(Pedido pedido, JdbcOperations jdbcOperations) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        return PedidoUseCase.cadastrar(pedido, pedidoGateway);
    }

    @Override
    public List<Pedido> listar(JdbcOperations jdbcOperations) {
        PedidoGatewayInterface pedidoGateway = new PedidoGateway(jdbcOperations);
        return PedidoUseCase.listar(pedidoGateway);
    }
}
