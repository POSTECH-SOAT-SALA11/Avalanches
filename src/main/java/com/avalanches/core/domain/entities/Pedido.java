package com.avalanches.core.domain.entities;

import jdk.jfr.Timespan;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

public class Pedido {

    private String id = UUID.randomUUID().toString();

    private StatusPedido status;

    private BigDecimal valor;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataFinalizacao;

    // FIXME: Analisar como vai ser feito
    private Timespan tempoEspera;

    private List<Produto> listaProduto;

    private Cliente cliente;

}
