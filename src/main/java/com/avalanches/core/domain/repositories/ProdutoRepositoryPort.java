package com.avalanches.core.domain.repositories;

import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.core.domain.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public interface ProdutoRepositoryPort {

    void insert(Produto produto);
    List<Produto> getProdutos(CategoriaProduto categoriaProduto);
    void update(Produto produto);

    void delete(int id);

    List<Imagem> getImagensPorProduto(int id);
}
