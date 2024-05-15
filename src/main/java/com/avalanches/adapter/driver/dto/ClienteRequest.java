package com.avalanches.adapter.driver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequest(
        @NotBlank(message = "nome cannot be empty")
        String nome,
        @NotBlank(message = "cpf cannot be empty")
        @CPF
        String cpf,
        @NotBlank(message = "email cannot be empty")
        @Email
        String email
) {
}
