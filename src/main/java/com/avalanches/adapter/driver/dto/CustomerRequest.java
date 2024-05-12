package com.avalanches.adapter.driver.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CustomerRequest(
        @NotBlank(message = "name cannot be empty")
        String name,
        @NotBlank(message = "cpf cannot be empty")
        @CPF
        String document,
        @NotBlank(message = "email cannot be empty")  String email
) {
}
