package com.avalanches.enterprisebusinessrules.entities;

public class Cliente {

    private Integer id;

    private String nome;

    private String cpf;

    private String email;

    public Cliente(Integer id,String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
