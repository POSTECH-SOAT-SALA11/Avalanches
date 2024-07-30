package com.avalanches.frameworksanddrivers.api;


import com.avalanches.applicationbusinessrules.usecases.PagamentoUseCase;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.frameworksanddrivers.api.interfaces.PagamentoApiInterface;
import com.avalanches.interfaceadapters.controllers.PagamentoController;
import com.avalanches.interfaceadapters.controllers.interfaces.PagamentoControllerInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoClientInterface;
import com.avalanches.interfaceadapters.presenters.dtos.WebHookDto;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avalanches/v1/pagamento")
@Validated
public class PagamentoApi implements PagamentoApiInterface {

    @Inject
    private JdbcOperations jdbcOperations;

    @Inject
    private PagamentoClientInterface client;

    @PostMapping("/webhook")
    @Override
    public ResponseEntity<WebHookDto> webhook(@Valid @RequestBody WebhookParams webhook) {
        try {
            System.out.println("Payload recebido: idPedido=" + webhook.idPedido() + ", status=" + webhook.status());
            PagamentoControllerInterface pagamentoController = new PagamentoController();
            pagamentoController.webhook(webhook, jdbcOperations);
            return ResponseEntity.ok(new WebHookDto(true, "Webhook recebido com sucesso"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new WebHookDto(false, "Ocorreu um erro ao processar o webhook"));
        }
    }


}
