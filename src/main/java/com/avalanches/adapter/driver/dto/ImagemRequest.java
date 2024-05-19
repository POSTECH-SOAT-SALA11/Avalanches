package com.avalanches.adapter.driver.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ImagemRequest(
        int id,
        @NotBlank(message = "Nome é um campo obrigatório.")
        String nome,
        @NotBlank(message = "Descrição é um campo obrigatório.")
        String descricao,
        @NotBlank(message = "TipoConteudo é um campo obrigatório.")
        String tipoConteudo,
        @NotNull(message = "Tamanho é um campo obrigatório.")
        int tamanho,
        @NotNull(message = "Conteúdo é um campo obrigatório.")
        byte[] conteudo
) {
}
