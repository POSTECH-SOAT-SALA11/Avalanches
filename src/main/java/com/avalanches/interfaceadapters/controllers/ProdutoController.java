package com.avalanches.interfaceadapters.controllers;

import com.avalanches.applicationbusinessrules.usecases.ProdutoUseCase;
import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.controllers.interfaces.ProdutoControllerInterface;
import com.avalanches.interfaceadapters.gateways.ImagemGateway;
import com.avalanches.interfaceadapters.gateways.ProdutoGateway;
import com.avalanches.interfaceadapters.gateways.interfaces.ImagemGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProdutoController implements ProdutoControllerInterface {

    @Override
    public void cadastrarProduto(Produto produto, JdbcOperations jdbcOperations) {
        ProdutoGatewayInterface produtoGateway = new ProdutoGateway(jdbcOperations);
        ImagemGatewayInterface imagemGateway = new ImagemGateway(jdbcOperations);
        ProdutoUseCase.cadastrarProduto(produto, produtoGateway, imagemGateway);
    }

    @Override
    public List<Produto> consultarProdutos(CategoriaProduto categoriaProduto, JdbcOperations jdbcOperations) {
        ProdutoGatewayInterface produtoGateway = new ProdutoGateway(jdbcOperations);
        ImagemGatewayInterface imagemGateway = new ImagemGateway(jdbcOperations);
        return ProdutoUseCase.consultarProdutos(categoriaProduto, produtoGateway, imagemGateway);
    }

    @Override
    public void atualizarProduto(Produto produto, JdbcOperations jdbcOperations) {
        ProdutoGatewayInterface produtoGateway = new ProdutoGateway(jdbcOperations);
        ImagemGatewayInterface imagemGateway = new ImagemGateway(jdbcOperations);
        ProdutoUseCase.atualizarProduto(produto, produtoGateway, imagemGateway);
    }

    @Override
    public void excluirProduto(int id, JdbcOperations jdbcOperations) {
        ProdutoGatewayInterface produtoGateway = new ProdutoGateway(jdbcOperations);
        ImagemGatewayInterface  imagemGateway = new ImagemGateway(jdbcOperations);
        ProdutoUseCase.excluirProduto(id, produtoGateway, imagemGateway);
    }
}
