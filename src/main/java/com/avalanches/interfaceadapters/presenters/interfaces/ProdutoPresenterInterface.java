package com.avalanches.interfaceadapters.presenters.interfaces;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import com.avalanches.enterprisebusinessrules.entities.Imagem;
import com.avalanches.enterprisebusinessrules.entities.Produto;
import com.avalanches.interfaceadapters.presenters.dtos.CategoriaProdutoDto;
import com.avalanches.interfaceadapters.presenters.dtos.ImagemDto;
import com.avalanches.interfaceadapters.presenters.dtos.ProdutoDto;

import java.util.List;

public interface ProdutoPresenterInterface {

    List<ProdutoDto> produtosToDtos(List<Produto> produtos);

    ProdutoDto produtoToDto(Produto produto);

    List<ImagemDto> imagensToDtos(List<Imagem> imagens);

    ImagemDto imagemToDto(Imagem imagem);

    CategoriaProdutoDto categoriaProdutoToDto(CategoriaProduto categoriaProduto);

}
