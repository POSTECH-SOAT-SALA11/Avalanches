package com.avalanches.interfaceadapters.gateways;

import com.avalanches.enterprisebusinessrules.entities.Pagamento;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoGatewayInterface;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.JdbcOperations;

public class PagamentoGateway implements PagamentoGatewayInterface {

    @Inject
    private JdbcOperations jdbcOperations;

    public PagamentoGateway(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void cadastrar(Pagamento pagamento) {
        jdbcOperations.update("INSERT INTO pagamento (id_pedido, status) VALUES (?,?)",
                pagamento.getIdPedido(),
                pagamento.getStatusPagamento().name()); // Converte o enum para string
    }
}
