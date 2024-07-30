package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.applicationbusinessrules.usecases.interfaces.PagamentoUseCaseInterface;
import com.avalanches.enterprisebusinessrules.entities.Pagamento;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;

public class PagamentoUseCase implements PagamentoUseCaseInterface {

    @Override
    public void cadastrar(WebhookParams webhook, PagamentoGatewayInterface pagamentoGateway){
        Pagamento pagamento = montarPagamento(webhook);
        pagamentoGateway.cadastrar(pagamento);
    }

    @Override
    public boolean efetuarPagamento(Integer idPedido, PagamentoGatewayInterface pagamentoGateway) {
        return pagamentoGateway.efetuarPagamento(idPedido);
    }

    private static Pagamento montarPagamento(WebhookParams webhook) {
        return new Pagamento(1, webhook.idPedido(), webhook.status());
    }

}
