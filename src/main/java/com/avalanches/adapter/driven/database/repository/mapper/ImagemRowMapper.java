package com.avalanches.adapter.driven.database.repository.mapper;

import com.avalanches.core.domain.entities.Imagem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ImagemRowMapper implements RowMapper<Imagem> {
    public Imagem mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Imagem(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getString("tipoConteudo"),
                rs.getInt("tamanho"),
                rs.getString("caminho"),
                null
        );
    }
}

