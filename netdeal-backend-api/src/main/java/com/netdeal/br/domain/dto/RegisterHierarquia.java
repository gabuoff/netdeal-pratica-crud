package com.netdeal.br.domain.dto;

import com.netdeal.br.businessrule.message.AppMessages;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterHierarquia(
    @NotBlank(message = AppMessages.CARGO_INVALIDO)
    @Size(min = 3, max = 100, message = "Cargo deve ter entre 1 a 100 caracteres")
    String cargo,
    
    @NotBlank(message = AppMessages.HIERARQUIA_INVALIDO)
    @Size(min = 1, max = 10, message = "Hierarquia deve ter entre 1 a 10 caracteres")
    @Pattern(regexp = "\\d+", message = "Hierarquia deve ser um número")
    Integer hierarquia
) {
    
}