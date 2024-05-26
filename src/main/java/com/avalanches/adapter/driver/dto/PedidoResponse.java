package com.avalanches.adapter.driver.dto;

import com.avalanches.core.domain.entities.PedidoProduto;
import com.avalanches.core.domain.entities.StatusPedido;

import java.math.BigDecimal;
import java.time.Duration;
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
