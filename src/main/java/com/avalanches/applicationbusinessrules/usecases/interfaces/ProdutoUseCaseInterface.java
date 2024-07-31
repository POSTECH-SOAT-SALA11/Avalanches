package com.avalanches.applicationbusinessrules.usecases.interfaces;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.gateways.interfaces.ImagemGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoUseCaseInterface {

    void cadastrarProduto(Produto produto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway);

    void atualizarProduto(Produto produto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway);

    void excluirProduto(int id, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway);

    List<Produto> consultarProdutos(CategoriaProduto categoriaProduto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway);

}
