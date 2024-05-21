package com.avalanches.adapter.driven.database.repository.mapper;

import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Produto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoRowMapper implements RowMapper<Produto> {
    public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {

        var a = rs.getString("categoria");

        return new Produto(
                rs.getInt("id"),
                rs.getBigDecimal("valor"),
                rs.getInt("quantidade"),
                new CategoriaProdutoMapper().mapValueToEnum(rs.getString("categoria")),
                rs.getString("nome"),
                rs.getString("descricao"),
                null
        );
    }
}
