package com.avalanches.core.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public class Produto {

    public int id;

    public BigDecimal valor;

    public int quantidade;

    public CategoriaProduto categoria;

    public String nome;

    public String descricao;

    public List<Imagem> imagens;

    public Produto(
        int id,
        BigDecimal valor,
        int quantidade,
        CategoriaProduto categoria,
        String nome,
        String descricao,
        List<Imagem> imagens
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
