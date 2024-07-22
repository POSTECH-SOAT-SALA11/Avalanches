package com.avalanches.frameworksanddrivers.api.interfaces;

import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.presenters.dtos.WebHookDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;

public interface PagamentoApiInterface {

    @Operation(summary = "webhook status papgamento",
            description = "Endpoint utilizado para obter o status do pagamento")
    ResponseEntity<WebHookDto> webhook(WebhookParams webhook);
}
