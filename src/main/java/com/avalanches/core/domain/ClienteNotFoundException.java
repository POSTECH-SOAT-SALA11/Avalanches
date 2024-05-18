package com.avalanches.core.domain;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String cpf) {
        super("CPF " + cpf + " não encontrado.");
    }
}