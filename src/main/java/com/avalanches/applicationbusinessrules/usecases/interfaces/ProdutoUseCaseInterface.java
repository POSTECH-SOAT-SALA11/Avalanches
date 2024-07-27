package com.avalanches.applicationbusinessrules.usecases.interfaces;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoUseCaseInterface {

    void cadastrarProduto(Produto produto);

    List<Produto> consultarProdutos(CategoriaProduto categoriaProduto);

    void atualizarProduto(Produto produto);

    void excluirProduto(int id);

}
