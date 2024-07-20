package com.avalanches.interfaceadapters.presenters.dtos;

public class ClienteDto {
    public Integer id;

    public String nome;

    public String cpf;

    public String email;

    public ClienteDto(
        Integer id,
        String nome,
        String cpf,
        String email
    ) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
