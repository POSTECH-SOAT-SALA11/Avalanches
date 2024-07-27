package com.avalanches.interfaceadapters.gateways.mapper;

import com.avalanches.enterprisebusinessrules.entities.Imagem;
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

