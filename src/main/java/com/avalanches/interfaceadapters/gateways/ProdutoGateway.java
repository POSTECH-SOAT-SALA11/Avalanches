package com.avalanches.interfaceadapters.gateways;


import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import com.avalanches.interfaceadapters.gateways.mapper.ImagemRowMapper;
import com.avalanches.interfaceadapters.gateways.mapper.ProdutoRowMapper;
import jakarta.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.webjars.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class ProdutoGateway implements ProdutoGatewayInterface {

    // TODO: pesquisar como fazer no springboot via interface
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void cadastrar(Produto produto) {
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
    }

    @Override
    public void cadastrarImagemProduto(int idProduto, int idImagem) {
        jdbcTemplate.update(
                "INSERT INTO produto_imagem(idproduto, idimagem) VALUES (?, ?);",
                idProduto,
                idImagem
        );
    }

    @Override
    public void atualizar(Produto produto) {
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

    @Override
    public void excluir(int id) {
        jdbcTemplate.update("DELETE FROM produto WHERE id=?", id);
    }

    @Override
    public void excluirImagemProduto(int idProduto, int idImagem) {
        jdbcTemplate.update("DELETE FROM produto_imagem WHERE idproduto=? AND idimagem=?", idProduto, idImagem);
    }

    @Override
    public List<Produto> consultarProdutos(CategoriaProduto categoriaProduto) {
        return jdbcTemplate.query("SELECT id,valor,quantidade,categoria," +
                "nome,descricao FROM produto where categoria=?",new ProdutoRowMapper(), categoriaProduto.getValue());
    }

    @Override
    public Produto consultarProdutosPorID(int id) {
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT id, valor, quantidade, categoria, nome, descricao FROM produto WHERE id = ?",
                    new ProdutoRowMapper(),
                    id
            );
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Produto não existe");
        }
    }

    @Override
    public List<Imagem> consultarImagensPorProduto(int id) {
        return jdbcTemplate.query("select i.* from produto_imagem pi2 " +
                "inner join imagem i on i.id = pi2.idimagem " +
                "where idproduto = ?",new ImagemRowMapper(), id);
    }

}

