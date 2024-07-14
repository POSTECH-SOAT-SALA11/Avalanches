package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.enterprisebusinessrules.entities.Pedido;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PedidoControllerInterface {
    Integer cadastrar(Pedido pedido, JdbcOperations jdbcOperations);

    List<Pedido> listar(JdbcOperations jdbcOperations);
}
