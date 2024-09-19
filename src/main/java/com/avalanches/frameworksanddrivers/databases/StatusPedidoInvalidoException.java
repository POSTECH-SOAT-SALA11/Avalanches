package com.avalanches.frameworksanddrivers.databases;

import com.avalanches.enterprisebusinessrules.entities.StatusPedido;

public class StatusPedidoInvalidoException extends RuntimeException {
    public StatusPedidoInvalidoException(StatusPedido statusPedido) {
        super("A atualização para o status " + statusPedido + " é inválida");
    }
}
