package com.avalanches.frameworksanddrivers.api.interfaces;

import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.presenters.dtos.WebHookDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface PagamentoApiInterface {

    @Operation(summary = "webhook status papgamento",
            description = "Endpoint utilizado para obter o status do pagamento")
    ResponseEntity<WebHookDto> webhook(@Valid @RequestBody WebhookParams webhook);
}
