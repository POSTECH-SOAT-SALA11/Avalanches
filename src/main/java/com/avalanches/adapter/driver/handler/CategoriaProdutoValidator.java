package com.avalanches.adapter.driver.handler;

import com.avalanches.core.domain.entities.CategoriaProduto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CategoriaProdutoValidator implements ConstraintValidator<ValidarCategoriaProduto, CategoriaProduto> {

    @Override
    public void initialize(ValidarCategoriaProduto constraintAnnotation) {
    }

    @Override
    public boolean isValid(CategoriaProduto categoria, ConstraintValidatorContext context) {
        if (categoria == null || categoria.getValue() == null || categoria.getValue().trim().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Categoria é um campo obrigatório.").addConstraintViolation();
            return false;
        }

        if (!CategoriaProduto.isValid(categoria.getValue())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Categoria inválida").addConstraintViolation();
            return false;
        }

        return true;
    }


}
