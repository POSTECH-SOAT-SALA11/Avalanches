package com.avalanches.core.application.usecases;

import com.avalanches.core.domain.entities.Imagem;
import com.avalanches.core.domain.entities.CategoriaProduto;
import com.avalanches.core.domain.entities.Produto;
import com.avalanches.core.domain.repositories.ProdutoRepositoryPort;
import com.avalanches.core.domain.repositories.ImagemRepositoryPort;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

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

        for (Imagem imagem: produto.imagens) {
            produtoRepository.insertProdutoImagem(produto.id, imagem.id);
        }
    }

    @Override
    public void updateProduto(Produto produto) {
        var preUpdateProduto = produtoRepository.getProdutoPorId(produto.id);
        if(preUpdateProduto == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        var preUpdatedImagens = produtoRepository.getImagensPorProduto(produto.id);
        if(preUpdatedImagens != null) {
            List<Imagem> deletedImagens;

            if(produto.imagens != null) {
                deletedImagens = preUpdatedImagens.stream()
                        .filter(preUpdatedImagem -> produto.imagens.stream().noneMatch(imagem -> imagem.id == preUpdatedImagem.id))
                        .toList();
            } else {
                deletedImagens = preUpdatedImagens;
            }

            for (Imagem imagem: deletedImagens) {
                produtoRepository.deleteProdutoImagem(produto.id, imagem.id);
                imagemRepository.delete(imagem);
            }
        }

        if(produto.imagens != null) {
            List<Imagem> updatedImagens = produto.imagens.stream().filter(imagem -> imagem.id != 0).toList();
            if(preUpdatedImagens != null) {
                for (Imagem imagem: updatedImagens) {
                    var preUpdatedImage = preUpdatedImagens.stream()
                            .filter(preUpdatedImagem -> preUpdatedImagem.id == imagem.id)
                            .findFirst();
                    preUpdatedImage.ifPresent(value -> imagem.caminho = value.caminho);
                }
            }

            for (Imagem imagem: updatedImagens) {
                imagemRepository.update(imagem);
            }

            List<Imagem> newImagens = produto.imagens.stream().filter(imagem -> imagem.id == 0).toList();
            for (Imagem imagem: newImagens) {
                imagemRepository.insert(imagem);
                produtoRepository.insertProdutoImagem(produto.id, imagem.id);
            }
        }
        produtoRepository.update(produto);
    }

    @Override
    public void deleteProduto(int id) {
        var produto = produtoRepository.getProdutoPorId(id);
        if(produto == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> deletedImagens = produtoRepository.getImagensPorProduto(id);
        if(deletedImagens != null) {
            for(Imagem imagem: deletedImagens) {
                produtoRepository.deleteProdutoImagem(id, imagem.id);
                imagemRepository.delete(imagem);
            }
        }
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
