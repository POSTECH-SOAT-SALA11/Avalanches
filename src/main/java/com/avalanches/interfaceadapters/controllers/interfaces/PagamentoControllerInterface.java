package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.frameworksanddrivers.api.dto.WebHookMockParams;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import org.springframework.jdbc.core.JdbcOperations;

public interface PagamentoControllerInterface {


    void webhook(WebhookParams webhook, JdbcOperations jdbcOperations, WebHookMockParams webHookMockParams);

}
