package com.avalanches.interfaceadapters.gateways.interfaces;


import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.enterprisebusinessrules.entities.Produto;

import java.util.List;

public interface ProdutoGatewayInterface {

    void cadastrar(Produto produto);

    void cadastrarImagemProduto(int idProduto, int idImagem);

    void atualizar(Produto produto);

    void excluir(int id);

    void excluirImagemProduto(int idProduto, int idImagem);

    List<Produto> consultarProdutos(CategoriaProduto categoriaProduto);

    Produto consultarProdutosPorID(int id);

    List<Imagem> consultarImagensPorProduto(int id);

    boolean verificaProdutoExiste(Integer idProduto);
}
