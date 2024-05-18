package com.avalanches.adapter.driver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record ClienteResponse(
        String nome,
        String cpf,
        String email
){
}
