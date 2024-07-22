package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.presenters.dtos.WebHookDto;
import org.springframework.jdbc.core.JdbcOperations;

public interface PagamentoControllerInterface {


    void webhook(WebhookParams webhook, JdbcOperations jdbcOperations);

}
