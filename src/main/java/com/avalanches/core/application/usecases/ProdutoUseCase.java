package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Produto;
import com.avalanches.core.domain.repositories.ProdutoRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ProdutoUseCase implements ProdutoUseCasePort {

    @Inject
    ProdutoRepositoryPort produtoRepository;

    @Override
    public void insertProduto(Produto produto) {
        produtoRepository.insert(produto);
    }

}
