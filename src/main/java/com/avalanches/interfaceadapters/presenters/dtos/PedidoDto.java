package com.avalanches.interfaceadapters.presenters.dtos;

import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class PedidoDto {
    public Integer id;

    public StatusPedidoDto status;

    public BigDecimal valor;

    public LocalDateTime dataCriacao;

    public LocalDateTime dataFinalizacao;

    public Duration tempoEspera;

    public List<PedidoProdutoDto> listaProduto;

    public Integer IdCliente;

    public PedidoDto(
        Integer id,
        StatusPedidoDto status,
        BigDecimal valor,
        LocalDateTime dataCriacao,
        LocalDateTime dataFinalizacao,
        Duration tempoEspera,
        List<PedidoProdutoDto> listaProduto,
        Integer IdCliente
    ) {
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
