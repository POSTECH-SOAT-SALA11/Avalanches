package com.avalanches.frameworksanddrivers.api.dto;

import com.avalanches.enterprisebusinessrules.entities.StatusPagamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record WebhookParams(
        @NotNull @NotBlank(message = "id do pedido não pode ser vazio ou em branco") Integer idPedido,
        @NotNull @NotBlank(message = "status não pode ser vazio ou em branco") StatusPagamento status
) {
}
