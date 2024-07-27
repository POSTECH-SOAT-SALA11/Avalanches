package com.avalanches.frameworksanddrivers.databases;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String cpf) {
        super("CPF " + cpf + " não encontrado.");
    }
}