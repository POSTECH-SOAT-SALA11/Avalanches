package com.avalanches.adapter.driver.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequest(
        @NotBlank(message = "nome não pode ser vazio ou em branco")
        @Schema(description = "Nome do cliente", example = "Romario Silva")
        String nome,
        @NotBlank(message = "cpf não pode ser vazio ou em branco")
        @CPF
        @Schema(description = "CPF do cliente", example = "36184114050")
        String cpf,
        @NotBlank(message = "email não pode ser vazio ou em branco")
        @Email
        @Schema(description = "Email do cliente", example = "romario.silva@example.com")
        String email
) {
}
