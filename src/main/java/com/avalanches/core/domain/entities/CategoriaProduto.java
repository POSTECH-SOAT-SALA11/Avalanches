package com.avalanches.core.domain.entities;

public enum CategoriaProduto {
    LANCHE("Lanche"),
    ACOMPANHAMENTO("Acompanhamento"),
    BEBIDA("Bebida"),
    SOBREMESA("SOBREMESA");

    private final String value;

    CategoriaProduto(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }
}