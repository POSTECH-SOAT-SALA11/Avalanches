package com.avalanches.core.domain.entities;

public class Cliente {

    public Integer id;

    public String nome;

    public String cpf;

    public String email;

    public Cliente(Integer id,String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

}
