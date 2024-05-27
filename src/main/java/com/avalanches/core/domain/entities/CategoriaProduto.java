package com.avalanches.core.domain.entities;

public enum CategoriaProduto {
    LANCHE("lanche"),
    ACOMPANHAMENTO("acompanhamento"),
    BEBIDA("bebida"),
    SOBREMESA("sobremesa");

    private final String value;

    CategoriaProduto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static CategoriaProduto fromValue(String value) {
        for (CategoriaProduto categoria : CategoriaProduto.values()) {
            if (categoria.getValue().equalsIgnoreCase(value)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Invalid CategoriaProduto value: " + value);
    }

    public static boolean isValid(String value) {
        for (CategoriaProduto categoria : values()) {
            if (categoria.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}