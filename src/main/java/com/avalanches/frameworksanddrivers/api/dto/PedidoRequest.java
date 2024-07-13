package com.avalanches.frameworksanddrivers.api.dto;

import com.avalanches.enterprisebusinessrules.entities.PedidoProduto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record PedidoRequest (

        @Schema(description = "Valor do pedido", example = "48")
        BigDecimal valor,

        LocalDateTime dataCriacao,

        LocalDateTime dataFinalizacao,

        @Schema(description = "Lista de Produtos", example = "[\n" +
                "  {\n" +
                "    \"idProduto\": 1,\n" +
                "    \"quantidade\": 1,\n" +
                "    \"valorUnitario\": 10.50\n" +
                "  },\n" +
                "  {\n" +
                "    \"idProduto\": 2,\n" +
                "    \"quantidade\": 2,\n" +
                "    \"valorUnitario\": 8.75\n" +
                "  },\n" +
                "  {\n" +
                "    \"idProduto\": 3,\n" +
                "    \"quantidade\": 1,\n" +
                "    \"valorUnitario\": 20.00\n" +
                "  }\n" +
                "]")
        List<PedidoProduto> listaProduto,

        @Schema(description = "Id do cliente", example = "1")
        Integer IdCliente
){
}
