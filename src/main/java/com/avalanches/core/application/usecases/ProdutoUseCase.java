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
    public void cadastrarProduto(Produto produto) {
        produtoRepository.cadastrar(produto);

        if(produto.imagens != null) {
            for (Imagem imagem: produto.imagens) {
                imagemRepository.cadastrar(imagem);
                produtoRepository.cadastrarImagemProduto(produto.id, imagem.id);
            }
        }
    }

    @Override
    public void atualizarProduto(Produto produto) {
        Produto preUpdatedProduto = produtoRepository.consultarProdutosPorID(produto.id);
        if(preUpdatedProduto == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> preUpdatedImagens = produtoRepository.consultarImagensPorProduto(produto.id);
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
                produtoRepository.excluirImagemProduto(produto.id, imagem.id);
                imagemRepository.excluir(imagem);
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
                imagemRepository.atualizar(imagem);
            }

            List<Imagem> newImagens = produto.imagens.stream().filter(imagem -> imagem.id == 0).toList();
            for (Imagem imagem: newImagens) {
                imagemRepository.cadastrar(imagem);
                produtoRepository.cadastrarImagemProduto(produto.id, imagem.id);
            }
        }
        produtoRepository.cadastrar(produto);
    }

    @Override
    public void excluirProduto(int id) {
        Produto produto = produtoRepository.consultarProdutosPorID(id);
        if(produto == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> deletedImagens = produtoRepository.consultarImagensPorProduto(id);
        if(deletedImagens != null) {
            for(Imagem imagem: deletedImagens) {
                produtoRepository.excluirImagemProduto(id, imagem.id);
                imagemRepository.excluir(imagem);
            }
        }
        produtoRepository.excluir(id);
    }

    @Override
    public List<Produto> consultarProdutos(CategoriaProduto categoriaProduto) {
        List<Produto> listaProduto =  produtoRepository.consultarProdutos(categoriaProduto);

        for (Produto p: listaProduto){
            p.imagens = produtoRepository.consultarImagensPorProduto(p.id);

            for(Imagem im: p.imagens){
                im.conteudo = imagemRepository.lerArquivo(im.caminho);
            }
        }

        return listaProduto;
    }


}
