package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Produto;
import org.springframework.stereotype.Service;

@Service
public interface ProdutoUseCasePort {

    void insertProduto(Produto produto);

}
