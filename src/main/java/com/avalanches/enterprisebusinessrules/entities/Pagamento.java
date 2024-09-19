package com.avalanches.enterprisebusinessrules.entities;

public class Pagamento {

    private Integer id;
    private Integer idPedido;
    private StatusPagamento statusPagamento;

    public Pagamento(Integer id, Integer idPedido, StatusPagamento statusPagamento) {
        this.id = id;
        this.idPedido = idPedido;
        this.statusPagamento = statusPagamento;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }
}
