package com.avalanches.enterprisebusinessrules.entities;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    public Integer id;

    public StatusPedido status;

    public BigDecimal valor;

    public LocalDateTime dataCriacao;

    public LocalDateTime dataFinalizacao;

    public Duration tempoEspera;

    public List<PedidoProduto> listaProduto;

    public Integer IdCliente;

    public Pedido(
            Integer id,
            StatusPedido status,
            BigDecimal valor,
            LocalDateTime dataCriacao,
            LocalDateTime dataFinalizacao,
            Integer IdCliente
    ){
        this.id = id;
        this.status = status;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.dataFinalizacao = dataFinalizacao;
        this.listaProduto = new ArrayList<>();
        this.tempoEspera = Duration.between(dataCriacao, dataFinalizacao);
        this.IdCliente = IdCliente;
    }

    public Pedido(
            Integer id,
            StatusPedido status,
            BigDecimal valor,
            LocalDateTime dataCriacao,
            LocalDateTime dataFinalizacao,
            List<PedidoProduto> listaProduto,
            Integer IdCliente
    ){
        this.id = id;
        this.status = status;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.dataFinalizacao = dataFinalizacao;
        this.tempoEspera = Duration.between(dataCriacao, dataFinalizacao);
        this.listaProduto = listaProduto;
        this.IdCliente = IdCliente;
    }

    public void adicionarProduto(PedidoProduto produto) {
        this.listaProduto.add(produto);
    }
}
