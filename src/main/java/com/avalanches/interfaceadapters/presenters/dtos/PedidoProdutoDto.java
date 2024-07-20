package com.avalanches.interfaceadapters.presenters.dtos;

import java.math.BigDecimal;

public class PedidoProdutoDto {

    public int idProduto;

    public int quantidade;

    public BigDecimal valorUnitario;

    public PedidoProdutoDto(
        int idProduto,
        int quantidade,
        BigDecimal valorUnitario
    ) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }
}
