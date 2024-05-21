package com.avalanches.adapter.driven.database.repository.mapper;

import com.avalanches.core.domain.entities.CategoriaProduto;

import java.sql.SQLException;

public class CategoriaProdutoMapper {

    public CategoriaProduto mapValueToEnum(String categoriaValue) throws SQLException {

        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            if (categoria.getValue().equals(categoriaValue)) {
                return categoria;
            }
        }

        throw new IllegalArgumentException("Categoria desconhecida: " + categoriaValue);
    }
}
