package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.core.domain.entities.Produto;
import com.avalanches.core.domain.repositories.ProdutoRepositoryPort;
import com.avalanches.core.domain.repositories.ImagemRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ProdutoUseCase implements ProdutoUseCasePort {

    @Inject
    ProdutoRepositoryPort produtoRepository;

    @Inject
    ImagemRepositoryPort imagemRepository;

    @Override
    public void insertProduto(Produto produto) {
        if(produto.imagens != null) {
            for (Imagem imagem: produto.imagens) {
                imagemRepository.insert(imagem);
            }
        }
        produtoRepository.insert(produto);
    }

    @Override
    public void updateProduto(Produto produto) {
        produtoRepository.update(produto);
    }

    @Override
    public void deleteProduto(int id) {
        produtoRepository.delete(id);
    }

}
