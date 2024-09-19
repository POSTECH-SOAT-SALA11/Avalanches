package com.avalanches.interfaceadapters.presenters;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.presenters.dtos.CategoriaProdutoDto;
import com.avalanches.interfaceadapters.presenters.dtos.ImagemDto;
import com.avalanches.interfaceadapters.presenters.dtos.ProdutoDto;
import com.avalanches.interfaceadapters.presenters.interfaces.ProdutoPresenterInterface;

import java.util.ArrayList;
import java.util.List;

public class ProdutoPresenter implements ProdutoPresenterInterface {

    @Override
    public List<ProdutoDto> produtosToDtos(List<Produto> produtos) {
        List<ProdutoDto> produtoDtos;
        if (produtos != null) {
            produtoDtos = produtos
                    .stream()
                    .map(this::produtoToDto)
                    .toList();
        } else {
            produtoDtos = new ArrayList<>();
        }
        return produtoDtos;
    }

    @Override
    public ProdutoDto produtoToDto(Produto produto) {
        return new ProdutoDto(
            produto.getId(),
            produto.getValor(),
            produto.getQuantidade(),
            categoriaProdutoToDto(produto.getCategoria()),
            produto.getNome(),
            produto.getDescricao(),
            imagensToDtos(produto.getImagens())
        );
    }

    @Override
    public List<ImagemDto> imagensToDtos(List<Imagem> imagens) {
        List<ImagemDto> imagemDtos;
        if (imagens != null) {
            imagemDtos = imagens
                    .stream()
                    .map(this::imagemToDto)
                    .toList();
        } else {
            imagemDtos = new ArrayList<>();
        }
        return imagemDtos;
    }

    @Override
    public ImagemDto imagemToDto(Imagem imagem) {
        return new ImagemDto(
            imagem.getId(),
            imagem.getNome(),
            imagem.getDescricao(),
            imagem.getTipoConteudo(),
            imagem.getTamanho(),
            imagem.getCaminho(),
            imagem.getConteudo()
        );
    }

    @Override
    public CategoriaProdutoDto categoriaProdutoToDto(CategoriaProduto categoriaProduto) {
        return CategoriaProdutoDto.valueOf(categoriaProduto.name());
    }

}
