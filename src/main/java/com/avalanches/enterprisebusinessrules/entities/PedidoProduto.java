package com.avalanches.enterprisebusinessrules.entities;

import java.math.BigDecimal;

public class PedidoProduto {

    private int idProduto;

    private int quantidade;

    private BigDecimal valorUnitario;

    public PedidoProduto(int idProduto, int quantidade, BigDecimal valorUnitario) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }
}
