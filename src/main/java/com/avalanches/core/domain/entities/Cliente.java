package com.avalanches.core.domain.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cliente {

    private String id;

    private String nome;

    private String cpf;

    private String email;

    public Cliente(String name, String document, String email) {
        this.id = UUID.randomUUID().toString();
        this.nome = name;
        this.cpf = document;
        this.email = email;
    }

    public String getId() {
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
