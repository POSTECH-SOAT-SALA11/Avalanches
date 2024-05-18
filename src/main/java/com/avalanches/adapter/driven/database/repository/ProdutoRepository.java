package com.avalanches.adapter.driven.database.repository;

import com.avalanches.core.domain.entities.Produto;
import com.avalanches.core.domain.repositories.ProdutoRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository implements ProdutoRepositoryPort {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Produto produto) {
        jdbcTemplate.update(
            "INSERT INTO produto(nome, descricao, categoria, quantidade, valor) VALUES (?, ?, ?, ?, ?);",
            produto.nome,
            produto.descricao,
            produto.categoria.ordinal(),
            produto.quantidade,
            produto.valor
        );
    }

}
