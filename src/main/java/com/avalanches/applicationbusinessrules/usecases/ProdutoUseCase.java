package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.gateways.interfaces.ImagemGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class ProdutoUseCase{

    public static void cadastrarProduto(Produto produto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
        produtoGateway.cadastrar(produto);

        if(produto.imagens != null) {
            for (Imagem imagem: produto.imagens) {
                imagemGateway.cadastrar(imagem);
                produtoGateway.cadastrarImagemProduto(produto.id, imagem.id);
            }
        }
    }

    public static void atualizarProduto(Produto produto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
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

    public static void excluirProduto(int id, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
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

    public static List<Produto> consultarProdutos(CategoriaProduto categoriaProduto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
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
