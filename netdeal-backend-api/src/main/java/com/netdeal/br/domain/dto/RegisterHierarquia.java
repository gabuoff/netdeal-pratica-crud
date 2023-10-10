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
    @Size(min = 1, max = 2, message = AppMessages.MAX_HIERARQUIA)
    @Pattern(regexp = "\\d+", message = AppMessages.ONLY_NUMBER)
    Integer hierarquia
) {
    
}