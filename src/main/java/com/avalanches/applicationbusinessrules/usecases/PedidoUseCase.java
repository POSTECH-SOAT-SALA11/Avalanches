package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.applicationbusinessrules.usecases.interfaces.PedidoUseCaseInterface;
import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import com.avalanches.interfaceadapters.gateways.interfaces.PedidoGatewayInterface;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoUseCase implements PedidoUseCaseInterface {

    @Inject
    PedidoGatewayInterface pedidoGatewayInterface;

    @Override
    public Integer cadastrar(Pedido pedido) {
        pedidoGatewayInterface.cadastrar(pedido);

        for(PedidoProduto p: pedido.listaProduto)
            pedidoGatewayInterface.cadastrarProdutosPorPedido(pedido.id, p);

        return pedido.id;
    }


    @Override
    public List<Pedido> listar() {
        return pedidoGatewayInterface.listar();
    }

}
