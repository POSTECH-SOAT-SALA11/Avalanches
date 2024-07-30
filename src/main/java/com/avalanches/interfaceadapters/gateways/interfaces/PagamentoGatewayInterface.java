package com.avalanches.interfaceadapters.gateways.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pagamento;
import com.avalanches.enterprisebusinessrules.entities.StatusPagamento;

public interface PagamentoGatewayInterface {

    void cadastrar(Pagamento pagamento);

    Boolean efetuarPagamento(Integer idPedido);

    boolean verificaPagamentoExiste(Integer idPedido);

    StatusPagamento consultaStatus(Integer idPedido);
}
