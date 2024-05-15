package com.avalanches.core.domain.entities;

import java.util.UUID;

public class Cliente {

    private UUID id;

    private String nome;

    private String cpf;

    private String email;

    public Cliente(String nome, String cpf, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public UUID getId() {
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
