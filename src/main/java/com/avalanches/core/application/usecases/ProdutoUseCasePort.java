package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ProdutoUseCasePort {

    void cadastrarProduto(Produto produto);

    List<Produto> consultarProdutos(CategoriaProduto categoriaProduto);

    void atualizarProduto(Produto produto);

    void excluirProduto(int id);

}
