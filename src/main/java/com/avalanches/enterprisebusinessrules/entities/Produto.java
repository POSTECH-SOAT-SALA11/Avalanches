package com.avalanches.enterprisebusinessrules.entities;

import java.math.BigDecimal;
import java.util.List;

public class Produto {

    private Integer id;

    private BigDecimal valor;

    private int quantidade;

    private CategoriaProduto categoria;

    private String nome;

    private String descricao;

    private List<Imagem> imagens;

    public Produto(
        int id,
        BigDecimal valor,
        int quantidade,
        CategoriaProduto categoria,
        String nome,
        String descricao,
        List<Imagem> imagens
    ) {
        this.setId(id);
        this.valor = valor;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.nome = nome;
        this.descricao = descricao;
        this.imagens = imagens;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem>imagens) {
        this.imagens = imagens;
    }

}
