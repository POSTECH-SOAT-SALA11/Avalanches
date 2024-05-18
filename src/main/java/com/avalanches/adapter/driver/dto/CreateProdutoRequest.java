package com.avalanches.adapter.driver.dto;

import com.avalanches.core.domain.entities.CategoriaProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateProdutoRequest(
        @NotNull(message = "Valor é um campo obrigatório.")
        BigDecimal valor,
        @NotNull(message = "Quantidade é um campo obrigatório.")
        Integer quantidade,
        @NotNull(message = "Categoria é um campo obrigatório.")
        CategoriaProduto categoria,
        @NotBlank(message = "Nome é um campo obrigatório.")
        String nome,
        @NotBlank(message = "Descrição é um campo obrigatório.")
        String descricao
//        List<Imagem> imagens
) {
}