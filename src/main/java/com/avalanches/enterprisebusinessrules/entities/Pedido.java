package com.avalanches.enterprisebusinessrules.entities;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Integer id;

    private StatusPedido status;

    private BigDecimal valor;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataFinalizacao;

    private Duration tempoEspera;

    private List<PedidoProduto> listaProduto;

    private Integer IdCliente;

    public Pedido(
            Integer id,
            StatusPedido status,
            BigDecimal valor,
            LocalDateTime dataCriacao,
            LocalDateTime dataFinalizacao,
            Integer IdCliente
    ){
        this.setId(id);
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
        this.setId(id);
        this.status = status;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
        this.dataFinalizacao = dataFinalizacao;
        this.tempoEspera = Duration.between(dataCriacao, dataFinalizacao);
        this.listaProduto = listaProduto;
        this.IdCliente = IdCliente;
    }

    public void adicionarProduto(PedidoProduto produto) {
        this.getListaProduto().add(produto);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataFinalizacao() {
        return dataFinalizacao;
    }

    public Duration getTempoEspera() {
        return tempoEspera;
    }

    public List<PedidoProduto> getListaProduto() {
        return listaProduto;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }
}
