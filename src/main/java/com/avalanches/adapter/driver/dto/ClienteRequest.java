package com.avalanches.adapter.driver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteRequest(
        @NotBlank(message = "nome não pode ser vazio ou em branco")
        String nome,
        @NotBlank(message = "cpf não pode ser vazio ou em branco")
        @CPF
        String cpf,
        @NotBlank(message = "email não pode ser vazio ou em branco")
        @Email
        String email
) {
}
