package com.avalanches.interfaceadapters.controllers.interfaces;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.presenters.dtos.ProdutoDto;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public interface ProdutoControllerInterface {
    void cadastrarProduto(Produto produto, JdbcOperations jdbcOperations);

    List<ProdutoDto> consultarProdutos(CategoriaProduto categoriaProduto, JdbcOperations jdbcOperations);

    void atualizarProduto(Produto produto, JdbcOperations jdbcOperations);

    void excluirProduto(int id, JdbcOperations jdbcOperations);
}
