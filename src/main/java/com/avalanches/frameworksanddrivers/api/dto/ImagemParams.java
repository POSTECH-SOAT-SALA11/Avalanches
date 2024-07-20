package com.avalanches.frameworksanddrivers.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ImagemParams(
        int id,
        @NotBlank(message = "Nome é um campo obrigatório.")
        @Schema(description = "Nome da imagem", example = "XAvalanche_frente")
        String nome,
        @NotBlank(message = "Descrição é um campo obrigatório.")
        @Schema(description = "Descrição da imagem", example = "Imagem XAvalanche")
        String descricao,
        @NotBlank(message = "TipoConteudo é um campo obrigatório.")
        @Schema(description = "Tipo da imagem", example = "jpg")
        String tipoConteudo,
        @NotNull(message = "Tamanho é um campo obrigatório.")
        @Schema(description = "Tamanho da imagem", example = "10")
        int tamanho,
        @NotNull(message = "Conteúdo é um campo obrigatório.")
        @Schema(description = "Conteúdo da imagem", example = "[\"1\"]")
        byte[] conteudo
) {
}
