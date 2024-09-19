package com.avalanches.enterprisebusinessrules.entities;

public class Imagem {

    private int id;

    private String nome;

    private String descricao;

    private String tipoConteudo;

    private int tamanho;

    private byte[] conteudo;

    private String caminho;

    public Imagem(int id, String nome, String descricao, String tipoConteudo, int tamanho, String caminho, byte[] conteudo) {
        this.setId(id);
        this.nome = nome;
        this.descricao = descricao;
        this.tipoConteudo = tipoConteudo;
        this.tamanho = tamanho;
        this.setCaminho(caminho);
        this.setConteudo(conteudo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTipoConteudo() {
        return tipoConteudo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
}
