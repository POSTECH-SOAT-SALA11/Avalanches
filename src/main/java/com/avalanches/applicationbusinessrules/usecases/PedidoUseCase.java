package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.applicationbusinessrules.usecases.interfaces.PedidoUseCaseInterface;
import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.interfaceadapters.gateways.interfaces.ClienteGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PedidoGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.List;

public class PedidoUseCase implements PedidoUseCaseInterface {

    @Override
    public Integer cadastrar(Pedido pedido,
                             PedidoGatewayInterface pedidoGateway,
                             ProdutoGatewayInterface produtoGateway,
                             PagamentoGatewayInterface pagamentoGateway,
                             ClienteGatewayInterface clienteGateway) {
        if(!clienteGateway.verificaClienteExiste(pedido.IdCliente)) {
            throw new NotFoundException("O cliente não foi encontrado.");
        }

        pedido.setValor(this.calcularValorTotal(pedido, produtoGateway));

        pedidoGateway.cadastrar(pedido);
        PagamentoUseCase pagamentoUseCase = new PagamentoUseCase();
        pagamentoUseCase.efetuarPagamento(pedido.id, pagamentoGateway);

        for(PedidoProduto p: pedido.listaProduto)
            pedidoGateway.cadastrarProdutosPorPedido(pedido.id, p);

        return pedido.id;
    }

    @Override
    public List<Pedido> listar(PedidoGatewayInterface pedidoGateway) {
        return pedidoGateway.listar();
    }

    @Override
    public void atualizaStatus(Integer idPedido, StatusPedido statusPedido, PedidoGatewayInterface pedidoGateway) {
        if (!pedidoGateway.verificaPedidoExiste(idPedido))  {
            throw new NotFoundException("Pedido não encontrado.");
        }
        pedidoGateway.atualizaStatus(idPedido, statusPedido);
    }


    private BigDecimal calcularValorTotal(Pedido pedido, ProdutoGatewayInterface produtoGateway) {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(PedidoProduto p: pedido.listaProduto){
            if(!produtoGateway.verificaProdutoExiste(p.idProduto)) {
                throw new NotFoundException("O produto " + p.idProduto + " não foi encontrado.");
            }
            BigDecimal valorProduto = p.valorUnitario.multiply(BigDecimal.valueOf(p.quantidade));
            valorTotal = valorTotal.add(valorProduto);
        }
        return valorTotal;
    }
}
