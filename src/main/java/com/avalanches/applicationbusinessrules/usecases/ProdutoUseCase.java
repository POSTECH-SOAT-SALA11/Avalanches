package com.avalanches.applicationbusinessrules.usecases;

import com.avalanches.applicationbusinessrules.usecases.interfaces.ProdutoUseCaseInterface;
import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.gateways.interfaces.ImagemGatewayInterface;
import com.avalanches.interfaceadapters.gateways.interfaces.ProdutoGatewayInterface;
import org.webjars.NotFoundException;

import java.util.List;

public class ProdutoUseCase implements ProdutoUseCaseInterface {

    @Override
    public void cadastrarProduto(Produto produto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
        produtoGateway.cadastrar(produto);

        if(produto.getImagens() != null) {
            for (Imagem imagem: produto.getImagens()) {
                imagemGateway.cadastrar(imagem);
                produtoGateway.cadastrarImagemProduto(produto.getId(), imagem.getId());
            }
        }
    }

    @Override
    public void atualizarProduto(Produto produto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
        Produto produtoPreAtualizado = produtoGateway.consultarProdutosPorID(produto.getId());
        if(produtoPreAtualizado == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> imagensPreAtualizadas = produtoGateway.consultarImagensPorProduto(produto.getId());
        if(imagensPreAtualizadas != null) {
            List<Imagem> imagensDeletadas;

            if(produto.getImagens() != null) {
                imagensDeletadas = imagensPreAtualizadas.stream()
                        .filter(preUpdatedImagem -> produto.getImagens().stream().noneMatch(imagem -> imagem.getId() == preUpdatedImagem.getId()))
                        .toList();
            } else {
                imagensDeletadas = imagensPreAtualizadas;
            }

            for (Imagem imagem: imagensDeletadas) {
                produtoGateway.excluirImagemProduto(produto.getId(), imagem.getId());
                imagemGateway.excluir(imagem);
            }
        }

        if(produto.getImagens() != null) {
            List<Imagem> imagensAtualizadas = produto.getImagens().stream().filter(imagem -> imagem.getId() != 0).toList();
            if(imagensPreAtualizadas != null) {
                for (Imagem imagem: imagensAtualizadas) {
                    var preUpdatedImage = imagensPreAtualizadas.stream()
                            .filter(preUpdatedImagem -> preUpdatedImagem.getId() == imagem.getId())
                            .findFirst();
                    preUpdatedImage.ifPresent(value -> imagem.setCaminho(value.getCaminho()));
                }
            }

            for (Imagem imagem: imagensAtualizadas) {
                imagemGateway.atualizar(imagem);
            }

            List<Imagem> novasImagens = produto.getImagens().stream().filter(imagem -> imagem.getId() == 0).toList();
            for (Imagem imagem: novasImagens) {
                imagemGateway.cadastrar(imagem);
                produtoGateway.cadastrarImagemProduto(produto.getId(), imagem.getId());
            }
        }
        produtoGateway.atualizar(produto);
    }

    @Override
    public void excluirProduto(int id, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
        Produto produto = produtoGateway.consultarProdutosPorID(id);
        if(produto == null) {
            throw new NotFoundException("Produto não encontrado.");
        }

        List<Imagem> imagensDeletadas = produtoGateway.consultarImagensPorProduto(id);
        if(imagensDeletadas != null) {
            for(Imagem imagem: imagensDeletadas) {
                produtoGateway.excluirImagemProduto(id, imagem.getId());
                imagemGateway.excluir(imagem);
            }
        }
        produtoGateway.excluir(id);
    }

    @Override
    public List<Produto> consultarProdutos(CategoriaProduto categoriaProduto, ProdutoGatewayInterface produtoGateway, ImagemGatewayInterface imagemGateway) {
        List<Produto> produtos =  produtoGateway.consultarProdutos(categoriaProduto);

        for (Produto produto: produtos){
            produto.setImagens(produtoGateway.consultarImagensPorProduto(produto.getId()));

            for(Imagem imagem: produto.getImagens()){
                imagem.setConteudo(imagemGateway.lerArquivo(imagem.getCaminho()));
            }
        }

        return produtos;
    }

}
