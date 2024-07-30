package com.avalanches.frameworksanddrivers.api.dto;

import com.avalanches.enterprisebusinessrules.entities.StatusPagamento;
import jakarta.validation.constraints.NotNull;

public record WebhookParams(
        @NotNull(message = "id do pedido não pode ser nulo") Integer idPedido,
        @NotNull(message = "status não pode ser nulo") StatusPagamento status
) {
}
