package com.avalanches.core.domain.entities;

import jdk.jfr.Timespan;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {

    public Integer id;

    public StatusPedido status;

    public BigDecimal valor;

    public LocalDateTime dataCriacao;

    public LocalDateTime dataFinalizacao;

    // FIXME: Analisar como vai ser feito
    public Timespan tempoEspera;

    public List<PedidoProduto> listaProduto;

    public Integer IdCliente;

    public Pedido(
            Integer id,
            StatusPedido status,
            BigDecimal valor,
            LocalDateTime dataCriacao,
            LocalDateTime dataFinalizacao,
            Timespan tempoEspera,
            List<PedidoProduto> listaProduto,
            Integer IdCliente
    ){
        this.id = id;
        this.status = status;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.dataFinalizacao = dataFinalizacao;
        this.tempoEspera = tempoEspera;
        this.listaProduto = listaProduto;
        this.IdCliente = IdCliente;
    }

}
