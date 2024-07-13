package com.avalanches.frameworksanddrivers.api.dto;

import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponse(

        Integer id,

        BigDecimal valor,

        StatusPedido statusPedido,

        LocalDateTime dataCriacao,

        LocalDateTime dataFinalizacao,

        List<PedidoProduto> listaProduto,

        Integer IdCliente
) {
}
