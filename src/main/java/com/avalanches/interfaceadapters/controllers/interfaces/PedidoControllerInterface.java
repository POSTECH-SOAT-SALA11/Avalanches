package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.interfaceadapters.gateways.interfaces.PagamentoClientInterface;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PedidoControllerInterface {

    Integer cadastrar(Pedido pedido, JdbcOperations jdbcOperations, PagamentoClientInterface pagamentoClient);

    void atualizaStatus(Integer idPedido, StatusPedido statusPedido, JdbcOperations jdbcOperations);

    List<PedidoDto> listar(JdbcOperations jdbcOperations);

}
