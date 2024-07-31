package com.avalanches.applicationbusinessrules.usecases.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PedidoGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PedidoUseCaseInterface {
    Integer cadastrar(Pedido pedido, PedidoGatewayInterface pedidoGateway, ProdutoGatewayInterface produtoGateway, PagamentoGatewayInterface pagamentoGateway, ClienteGatewayInterface clienteGateway);
    List<Pedido> listar(PedidoGatewayInterface pedidoGateway);
    void atualizaStatus(Integer idPedido, StatusPedido statusPedido, PedidoGatewayInterface pedidoGateway);
}
