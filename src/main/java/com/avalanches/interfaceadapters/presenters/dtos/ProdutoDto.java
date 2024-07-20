package com.avalanches.interfaceadapters.presenters.dtos;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDto {

    public Integer id;

    public BigDecimal valor;

    public int quantidade;

    public CategoriaProdutoDto categoria;

    public String nome;

    public String descricao;

    public List<ImagemDto> imagens;

    public ProdutoDto(
        int id,
        BigDecimal valor,
        int quantidade,
        CategoriaProdutoDto categoria,
        String nome,
        String descricao,
        List<ImagemDto> imagens
    ) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.imagens = imagens;
    }
}
