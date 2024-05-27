package com.avalanches.core.domain.entities;

import java.math.BigDecimal;

public class PedidoProduto {

    public int idProduto;

    public int quantidade;

    public BigDecimal valorUnitario;

    public PedidoProduto(int idProduto, int quantidade, BigDecimal valorUnitario) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }
}
