package com.avalanches.core.domain.entities;

public class Imagem {

    public int id;

    public String nome;

    public String descricao;

    public String tipoConteudo;

    public int tamanho;

    public byte[] conteudo;

    public String caminho;

    public Imagem(int id, String nome, String descricao, String tipoConteudo, int tamanho, byte[] conteudo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tipoConteudo = tipoConteudo;
        this.tamanho = tamanho;
        this.conteudo = conteudo;
    }
}

