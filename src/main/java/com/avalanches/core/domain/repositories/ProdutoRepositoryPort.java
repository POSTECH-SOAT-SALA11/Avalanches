package com.avalanches.core.domain.repositories;

import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.core.domain.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoRepositoryPort {

    void insert(Produto produto);

    void insertProdutoImagem(int idProduto, int idImagem);

    void update(Produto produto);

    void delete(int id);

    void deleteProdutoImagem(int idProduto, int idImagem);

    List<Produto> getProdutos(CategoriaProduto categoriaProduto);

    Produto getProdutoPorId(int id);

    List<Imagem> getImagensPorProduto(int id);
}
