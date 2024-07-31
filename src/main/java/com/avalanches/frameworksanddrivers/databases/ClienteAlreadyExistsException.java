package com.avalanches.frameworksanddrivers.databases;

public class ClienteAlreadyExistsException extends RuntimeException {
    public ClienteAlreadyExistsException(String cpf) {
        super("CPF " + cpf + " já está cadastrado.");
    }
}