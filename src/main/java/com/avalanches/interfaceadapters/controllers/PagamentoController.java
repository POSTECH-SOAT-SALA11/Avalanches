package com.avalanches.interfaceadapters.controllers;

import com.avalanches.applicationbusinessrules.usecases.PagamentoUseCase;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.controllers.interfaces.PagamentoControllerInterface;
import com.avalanches.interfaceadapters.gateways.PagamentoGateway;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;
import org.springframework.jdbc.core.JdbcOperations;

public class PagamentoController implements PagamentoControllerInterface {


    @Override
    public void webhook(WebhookParams webhook, JdbcOperations jdbcOperations) {
        PagamentoGatewayInterface pagamentoGateway = new PagamentoGateway(jdbcOperations);
        PagamentoUseCase.cadastrar(webhook, pagamentoGateway);
    }


}
