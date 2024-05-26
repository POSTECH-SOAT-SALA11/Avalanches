package com.avalanches.adapter.driven.database.repository;

import com.avalanches.core.domain.entities.Pedido;
import com.avalanches.core.domain.entities.PedidoProduto;
import com.avalanches.core.domain.entities.StatusPedido;
import com.avalanches.core.domain.repositories.PedidoRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PedidoRepository implements PedidoRepositoryPort {
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void cadastrar(Pedido pedido) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps = connection.prepareStatement(
                                "insert into pedido (status, valor, datacriacao, datafinalizacao, idcliente) values (?, ?, ? ,? ,?)",
                                Statement.RETURN_GENERATED_KEYS
                        );
                        ps.setString(1, pedido.status.getValue());
                        ps.setBigDecimal(2, pedido.valor);
                        ps.setTimestamp(3, Timestamp.valueOf(pedido.dataCriacao));
                        ps.setTimestamp(4, Timestamp.valueOf(pedido.dataFinalizacao));
                        ps.setInt(5, pedido.IdCliente);
                        return ps;
                    }
                },
                keyHolder
        );
        pedido.id = (int) keyHolder.getKeys().get("id");

    }

    @Override
    public void cadastrarProdutosPorPedido(Integer idPedido, PedidoProduto pedidoProduto) {
        jdbcTemplate.update("INSERT INTO pedido_produto (idPedido, idProduto, quantidade, valorUnitario) VALUES (?, ?, ?, ?);",
                idPedido,
                pedidoProduto.idProduto,
                pedidoProduto.quantidade,
                pedidoProduto.valorUnitario);
    }
}
