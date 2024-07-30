package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.enterprisebusinessrules.entities.Pagamento;
import com.avalanches.frameworksanddrivers.api.dto.WebhookParams;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoClientInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;

public class PagamentoUseCase {

    public static void cadastrar(WebhookParams webhook, PagamentoGatewayInterface pagamentoGateway){
        Pagamento pagamento = montarPagamento(webhook);
        pagamentoGateway.cadastrar(pagamento);
    }

    public static boolean efetuarPagamento(Integer idPedido, PagamentoClientInterface pagamentoClient) {

        return pagamentoClient.efetuarPagamento(idPedido);

    }

    private static Pagamento montarPagamento(WebhookParams webhook) {
        return new Pagamento(1, webhook.idPedido(), webhook.status());
    }
}
