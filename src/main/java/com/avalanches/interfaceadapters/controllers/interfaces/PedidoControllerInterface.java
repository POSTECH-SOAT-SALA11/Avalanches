package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import com.avalanches.enterprisebusinessrules.entities.StatusPedido;
import com.avalanches.frameworksanddrivers.api.dto.WebHookMockParams;
import com.avalanches.interfaceadapters.presenters.dtos.PedidoDto;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public interface PedidoControllerInterface {

    Integer cadastrar(Pedido pedido, JdbcOperations jdbcOperations, WebHookMockParams webHookMockParams);

    void atualizaStatus(Integer idPedido, StatusPedido statusPedido, JdbcOperations jdbcOperations);

    List<PedidoDto> listar(JdbcOperations jdbcOperations);

}
