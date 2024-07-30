package com.avalanches.frameworksanddrivers.api.interfaces;

import com.avalanches.enterprisebusinessrules.entities.StatusPagamento;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.presenters.dtos.WebHookDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PagamentoApiInterface {

    @Operation(summary = "Webhook status pagamento",
               description = "E utilizado para obter o status do pagamento via webhook")
    ResponseEntity<WebHookDto> webhook(@Valid @RequestBody WebhookParams webhook);

    @Operation(summary = "Consulta status pagamento",
               description = "Endpoint utilizado para consultar o status do pagamento")
    ResponseEntity<StatusPagamento> consultaStatus(@PathVariable("idPedido") Integer idPedido);

}
