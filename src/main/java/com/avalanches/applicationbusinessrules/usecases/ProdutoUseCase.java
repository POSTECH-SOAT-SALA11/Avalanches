package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.applicationbusinessrules.usecases.interfaces.ProdutoUseCaseInterface;
import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.gateways.interfaces.ImagemGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ProdutoUseCase implements ProdutoUseCaseInterface {

    @Inject
    ProdutoGatewayInterface produtoGateway;

    @Inject
    ImagemGatewayInterface imagemGateway;

    @Override
    public void cadastrarProduto(Produto produto) {
        produtoGateway.cadastrar(produto);

        if(produto.imagens != null) {
            for (Imagem imagem: produto.imagens) {
                imagemGateway.cadastrar(imagem);
                produtoGateway.cadastrarImagemProduto(produto.id, imagem.id);
            }
        }
    }

    @Override
    public void atualizarProduto(Produto produto) {
        Produto produtoPreAtualizado = produtoGateway.consultarProdutosPorID(produto.id);
        if(produtoPreAtualizado == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> imagensPreAtualizadas = produtoGateway.consultarImagensPorProduto(produto.id);
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
                produtoGateway.excluirImagemProduto(produto.id, imagem.id);
                imagemGateway.excluir(imagem);
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
                imagemGateway.atualizar(imagem);
            }

            List<Imagem> novasImagens = produto.imagens.stream().filter(imagem -> imagem.id == 0).toList();
            for (Imagem imagem: novasImagens) {
                imagemGateway.cadastrar(imagem);
                produtoGateway.cadastrarImagemProduto(produto.id, imagem.id);
            }
        }
        produtoGateway.atualizar(produto);
    }

    @Override
    public void excluirProduto(int id) {
        Produto produto = produtoGateway.consultarProdutosPorID(id);
        if(produto == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> imagensDeletadas = produtoGateway.consultarImagensPorProduto(id);
        if(imagensDeletadas != null) {
            for(Imagem imagem: imagensDeletadas) {
                produtoGateway.excluirImagemProduto(id, imagem.id);
                imagemGateway.excluir(imagem);
            }
        }
        produtoGateway.excluir(id);
    }

    @Override
    public List<Produto> consultarProdutos(CategoriaProduto categoriaProduto) {
        List<Produto> produtos =  produtoGateway.consultarProdutos(categoriaProduto);

        for (Produto produto: produtos){
            produto.imagens = produtoGateway.consultarImagensPorProduto(produto.id);

            for(Imagem imagem: produto.imagens){
                imagem.conteudo = imagemGateway.lerArquivo(imagem.caminho);
            }
        }

        return produtos;
    }


}
