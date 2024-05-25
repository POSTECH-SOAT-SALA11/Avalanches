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
        Produto produtoPreAtualizado = produtoRepository.consultarProdutosPorID(produto.id);
        if(produtoPreAtualizado == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> imagensPreAtualizadas = produtoRepository.consultarImagensPorProduto(produto.id);
        if(imagensPreAtualizadas != null) {
            List<Imagem> imagensDeletadas;

            if(produto.imagens != null) {
                imagensDeletadas = imagensPreAtualizadas.stream()
                        .filter(preUpdatedImagem -> produto.imagens.stream().noneMatch(imagem -> imagem.id == preUpdatedImagem.id))
                        .toList();
            } else {
                imagensDeletadas = imagensPreAtualizadas;
            }

            for (Imagem imagem: imagensDeletadas) {
                produtoRepository.excluirImagemProduto(produto.id, imagem.id);
                imagemRepository.excluir(imagem);
            }
        }

        if(produto.imagens != null) {
            List<Imagem> imagensAtualizadas = produto.imagens.stream().filter(imagem -> imagem.id != 0).toList();
            if(imagensPreAtualizadas != null) {
                for (Imagem imagem: imagensAtualizadas) {
                    var preUpdatedImage = imagensPreAtualizadas.stream()
                            .filter(preUpdatedImagem -> preUpdatedImagem.id == imagem.id)
                            .findFirst();
                    preUpdatedImage.ifPresent(value -> imagem.caminho = value.caminho);
                }
            }

            for (Imagem imagem: imagensAtualizadas) {
                imagemRepository.atualizar(imagem);
            }

            List<Imagem> novasImagens = produto.imagens.stream().filter(imagem -> imagem.id == 0).toList();
            for (Imagem imagem: novasImagens) {
                imagemRepository.cadastrar(imagem);
                produtoRepository.cadastrarImagemProduto(produto.id, imagem.id);
            }
        }
        produtoRepository.atualizar(produto);
    }

    @Override
    public void excluirProduto(int id) {
        Produto produto = produtoRepository.consultarProdutosPorID(id);
        if(produto == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> imagensDeletadas = produtoRepository.consultarImagensPorProduto(id);
        if(imagensDeletadas != null) {
            for(Imagem imagem: imagensDeletadas) {
                produtoRepository.excluirImagemProduto(id, imagem.id);
                imagemRepository.excluir(imagem);
            }
        }
        produtoRepository.excluir(id);
    }

    @Override
    public List<Produto> consultarProdutos(CategoriaProduto categoriaProduto) {
        List<Produto> produtos =  produtoRepository.consultarProdutos(categoriaProduto);

        for (Produto produto: produtos){
            produto.imagens = produtoRepository.consultarImagensPorProduto(produto.id);

            for(Imagem imagem: produto.imagens){
                imagem.conteudo = imagemRepository.lerArquivo(imagem.caminho);
            }
        }

        return produtos;
    }


}
