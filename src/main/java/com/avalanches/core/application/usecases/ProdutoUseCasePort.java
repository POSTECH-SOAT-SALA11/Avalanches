package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProdutoUseCasePort {

    void insertProduto(Produto produto);

    List<Produto> getProdutos(CategoriaProduto categoriaProduto);

    void updateProduto(Produto produto);

    void deleteProduto(int id);

}
