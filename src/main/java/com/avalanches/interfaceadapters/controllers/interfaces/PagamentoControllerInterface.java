package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.enterprisebusinessrules.entities.StatusPagamento;
import com.avalanches.frameworksanddrivers.api.dto.WebHookMockParams;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import org.springframework.jdbc.core.JdbcOperations;

public interface PagamentoControllerInterface {


    void webhook(WebhookParams webhook, JdbcOperations jdbcOperations, WebHookMockParams webHookMockParams);

    StatusPagamento consultaStatus(Integer idPedido, JdbcOperations jdbcOperations, WebHookMockParams webHookMockParams);

}
