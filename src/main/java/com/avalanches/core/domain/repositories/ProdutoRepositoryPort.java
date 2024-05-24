package com.avalanches.core.domain.repositories;

import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.core.domain.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoRepositoryPort {

    void cadastrar(Produto produto);

    void cadastrarImagemProduto(int idProduto, int idImagem);

    void atualizar(Produto produto);

    void excluir(int id);

    void excluirImagemProduto(int idProduto, int idImagem);

    List<Produto> consultarProdutos(CategoriaProduto categoriaProduto);

    Produto consultarProdutosPorID(int id);

    List<Imagem> consultarImagensPorProduto(int id);
}
