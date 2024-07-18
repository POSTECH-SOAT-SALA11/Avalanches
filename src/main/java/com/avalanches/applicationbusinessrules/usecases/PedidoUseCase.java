package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.interfaceadapters.gateways.interfaces.PedidoGatewayInterface;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PedidoUseCase{

    public static Integer cadastrar(Pedido pedido, PedidoGatewayInterface pedidoGateway) {
        pedidoGateway.cadastrar(pedido);

        for(PedidoProduto p: pedido.listaProduto)
            pedidoGateway.cadastrarProdutosPorPedido(pedido.id, p);

        return pedido.id;
    }


    public static List<Pedido> listar(PedidoGatewayInterface pedidoGateway) {
        return pedidoGateway.listar();
    }

    public static void atualizaStatus(Integer idPedido, StatusPedido statusPedido, PedidoGatewayInterface pedidoGateway) {
        if (!pedidoGateway.verificaPedidoExiste(idPedido))  {
           throw new NotFoundException("Pedido não encontrado.");
        }
        pedidoGateway.atualizaStatus(idPedido, statusPedido);
    }

}
