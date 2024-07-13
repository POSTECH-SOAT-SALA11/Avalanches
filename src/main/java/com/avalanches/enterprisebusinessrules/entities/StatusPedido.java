package com.avalanches.enterprisebusinessrules.entities;

public enum StatusPedido {
    RECEBIDO("Recebido"),
    EMPREPARACAO("EmPreparacao"),
    PRONTO("Pronto"),
    FINALIZADO("Finalizado");

    private final String value;

    StatusPedido(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static StatusPedido fromValue(String value) {
        for (StatusPedido status : StatusPedido.values()) {
            if (status.getValue().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid StatusPedido value: " + value);
    }
}
