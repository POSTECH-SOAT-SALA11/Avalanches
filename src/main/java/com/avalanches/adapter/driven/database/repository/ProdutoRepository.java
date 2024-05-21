package com.avalanches.adapter.driven.database.repository;

import com.avalanches.adapter.driven.database.repository.mapper.ImagemRowMapper;
import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.adapter.driven.database.repository.mapper.ProdutoRowMapper;
import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Produto;
import com.avalanches.core.domain.repositories.ProdutoRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

@Repository
public class ProdutoRepository implements ProdutoRepositoryPort {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Produto produto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
            new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement ps = connection.prepareStatement(
                            "INSERT INTO produto(nome, descricao, categoria, quantidade, valor) VALUES (?, ?, ?, ?, ?)",
                            Statement.RETURN_GENERATED_KEYS
                    );
                    ps.setString(1, produto.nome);
                    ps.setString(2, produto.descricao);
                    ps.setString(3, produto.categoria.getValue());
                    ps.setInt(4, produto.quantidade);
                    ps.setBigDecimal(5, produto.valor);
                    return ps;
                }
            },
            keyHolder
        );
        produto.id = (int) keyHolder.getKeys().get("id");

        for (Imagem imagem: produto.imagens) {
            jdbcTemplate.update(
                    "INSERT INTO produto_imagem(idproduto, idimagem) VALUES (?, ?);",
                    produto.id,
                    imagem.id
            );
        }
    }

    @Override
    public void update(Produto produto) {
        jdbcTemplate.update(
            "UPDATE produto SET nome=?, descricao=?, categoria=?, quantidade=?, valor=? WHERE id=?",
                produto.nome,
                produto.descricao,
                produto.categoria.getValue(),
                produto.quantidade,
                produto.valor,
                produto.id
        );
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM produto WHERE id=?", id);
    }

    @Override
    public List<Imagem> getImagensPorProduto(int id) {
        return jdbcTemplate.query("select i.* from produto_imagem pi2 " +
                "inner join imagem i on i.id = pi2.idimagem " +
                "where idproduto = ?",new ImagemRowMapper(), id);
    }

    @Override
    public List<Produto> getProdutos(CategoriaProduto categoriaProduto) {
        return jdbcTemplate.query("SELECT id, valor,quantidade,categoria," +
                "nome,descricao FROM produto where categoria=?",new ProdutoRowMapper(), categoriaProduto.getValue());
    }

}

