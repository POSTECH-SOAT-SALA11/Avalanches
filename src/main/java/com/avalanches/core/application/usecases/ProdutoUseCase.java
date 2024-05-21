package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Produto;
import com.avalanches.core.domain.repositories.ProdutoRepositoryPort;
import com.avalanches.core.domain.repositories.ImagemRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Produto> getProdutos(CategoriaProduto categoriaProduto) {
        var listaProduto =  produtoRepository.getProdutos(categoriaProduto);

        for (Produto p: listaProduto){
            p.imagens = produtoRepository.getImagensPorProduto(p.id);

            for(Imagem im: p.imagens){
                im.conteudo = imagemRepository.readFile(im.caminho);
            }
        }

        return listaProduto;
    }


}
