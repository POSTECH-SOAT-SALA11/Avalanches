package com.avalanches.adapter.driver.dto;

import com.avalanches.core.domain.entities.Cliente;
import com.avalanches.core.domain.entities.PedidoProduto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoRequest (
    BigDecimal valor,

    LocalDateTime dataCriacao,

    LocalDateTime dataFinalizacao,

    List<PedidoProduto> listaProduto,

    Integer IdCliente
){
}
