package com.avalanches.adapter.driven.database.repository;

import com.avalanches.core.domain.entities.Pedido;
import com.avalanches.core.domain.entities.PedidoProduto;
import com.avalanches.core.domain.entities.StatusPedido;
import com.avalanches.core.domain.repositories.PedidoRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.webjars.NotFoundException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Pedido> listar() {
        try {
            String sql = "SELECT p.id, p.status, p.valor, p.datacriacao, p.datafinalizacao, p.idcliente, "
                    + "pp.idproduto, pp.quantidade, pp.valorunitario "
                    + "FROM pedido p "
                    + "LEFT JOIN pedido_produto pp ON p.id = pp.idpedido";

            return jdbcTemplate.query(sql, new PedidoResultSetExtractor());
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Produto não existe");
        }
    }


    private static class PedidoResultSetExtractor implements ResultSetExtractor<List<Pedido>> {

        @Override
        public List<Pedido> extractData(ResultSet rs) throws SQLException {
            Map<Integer, Pedido> pedidoMap = new HashMap<>();

            while (rs.next()) {
                Integer pedidoId = rs.getInt("id");
                Pedido pedido = pedidoMap.get(pedidoId);


                if (pedido == null) {
                    LocalDateTime dataCriacao = rs.getTimestamp("datacriacao").toLocalDateTime();
                    LocalDateTime dataFinalizacao = rs.getTimestamp("datafinalizacao").toLocalDateTime();
                    pedido = new Pedido(
                            pedidoId,
                            StatusPedido.valueOf(rs.getString("status")),
                            rs.getBigDecimal("valor"),
                            dataCriacao,
                            dataFinalizacao,
                            rs.getInt("idcliente")
                    );
                    pedidoMap.put(pedidoId, pedido);
                }

                if (rs.getInt("idproduto") != 0) {
                    PedidoProduto pedidoProduto = new PedidoProduto(
                            rs.getInt("idproduto"),
                            rs.getInt("quantidade"),
                            rs.getBigDecimal("valorunitario")
                    );
                    pedido.adicionarProduto(pedidoProduto);
                }
            }

            return new ArrayList<>(pedidoMap.values());
        }
    }


}
