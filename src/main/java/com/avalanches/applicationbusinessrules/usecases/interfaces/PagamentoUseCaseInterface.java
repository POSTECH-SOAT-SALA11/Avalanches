package com.avalanches.applicationbusinessrules.usecases.interfaces;

import com.avalanches.enterprisebusinessrules.entities.StatusPagamento;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;

public interface PagamentoUseCaseInterface {

    public void cadastrar(WebhookParams webhook, PagamentoGatewayInterface pagamentoGateway);

    public boolean efetuarPagamento(Integer idPedido, PagamentoGatewayInterface pagamentoGateway);

    StatusPagamento consultaStatus(Integer idPedido, PagamentoGatewayInterface pagamentoGateway);

}
