package com.avalanches.frameworksanddrivers.api.dto;

import com.avalanches.enterprisebusinessrules.entities.CategoriaProduto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record ProdutoParams(
        int id,

        @NotNull(message = "Valor é um campo obrigatório.")
        @Schema(description = "Valor do produto", example = "10")
        BigDecimal valor,
        @NotNull(message = "Quantidade é um campo obrigatório.")
        @Schema(description = "Quantidade em estoque", example = "30")
        Integer quantidade,

        @Schema(description = "Categoria do produto", example = "LANCHE")
        CategoriaProduto categoria,

        @NotNull(message = "Nome é um campo obrigatório.")
        @Schema(description = "Nome do produto", example = "XAvalanche")
        String nome,
        @NotBlank(message = "Descrição é um campo obrigatório.")
        @Schema(description = "Descrição do produto", example = "XAvalanche com molho da casa")
        String descricao,
        @Valid() ImagemParams[] imagens
) {
}
