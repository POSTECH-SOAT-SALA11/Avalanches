package com.avalanches.core.domain.entities;

public class Cliente {

    private int id;

    private String nome;

    private String cpf;

    private String email;

    private static int nextId = 1;

    public Cliente(String name, String document, String email) {
        this.id = nextId++;
        this.nome = name;
        this.cpf = document;
        this.email = email;
    }

    public int getId() {
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

    public void setCpf(String document) {
        this.cpf = document;
    }
}
