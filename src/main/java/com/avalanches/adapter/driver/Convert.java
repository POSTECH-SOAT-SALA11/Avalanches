package com.avalanches.adapter.driver;

import com.avalanches.adapter.driver.dto.*;
import com.avalanches.core.domain.entities.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Convert {

    public static Cliente clienteRequestToCliente(ClienteRequest request) {
        return new Cliente(null, request.nome(), request.cpf(), request.email());
    }

    public static ClienteResponse clienteToClienteResponse(Cliente cliente){
        return new ClienteResponse(cliente.nome, cliente.cpf, cliente.email);
    }

    public static Produto produtoRequestToProduto(ProdutoRequest request) {
        return new Produto(
            request.id(),
            request.valor(),
            request.quantidade(),
            request.categoria(),
            request.nome(),
            request.descricao(),
            request.imagens() == null ? Collections.emptyList() : imagemRequestsToImagens(List.of(request.imagens()))
        );
    }

    public static List<Imagem> imagemRequestsToImagens(List<ImagemRequest> imagens) {
        if (imagens == null) {
            return Collections.emptyList();
        } else {
            return imagens.stream()
                    .map(imagemRequest -> new Imagem(
                        imagemRequest.id(),
                        imagemRequest.nome(),
                        imagemRequest.descricao(),
                        imagemRequest.tipoConteudo(),
                        imagemRequest.tamanho(),
                        null,
                        imagemRequest.conteudo()
                    ))
                    .collect(Collectors.toList());
        }
    }

    public static List<ProdutoResponse> listProdutoToListProdutoResponse(List<Produto> listaProduto) {

        List<ProdutoResponse> listaProdutoResponse = listaProduto.stream()
                .map(produto -> new ProdutoResponse(
                        produto.id,
                        produto.valor,
                        produto.quantidade,
                        produto.categoria,
                        produto.nome,
                        produto.descricao,
                        produto.imagens)).collect(Collectors.toList());

        return listaProdutoResponse;
    }

    public static Pedido pedidoRequestToPedido(PedidoRequest pedido) {
        return new Pedido(
                null,
                StatusPedido.EMPREPARACAO,
                pedido.valor(),
                pedido.dataCriacao(),
                pedido.dataFinalizacao(),
                pedido.listaProduto(),
                pedido.IdCliente()
        );
    }

    public static List<PedidoResponse> pedidoToPedidoResponse(List<Pedido> pedidos) {

        List<PedidoResponse> pedidosResponse = pedidos.stream().map( p ->
                new PedidoResponse(p.id, p.valor, p.status , p.dataCriacao, p.dataFinalizacao, p.listaProduto, p.IdCliente)).collect(Collectors.toList());

        return pedidosResponse;
    }

}