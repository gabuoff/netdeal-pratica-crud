package com.netdeal.br.domain.dto;

import com.netdeal.br.businessrule.message.AppMessages;

import jakarta.validation.constraints.NotBlank;

public record RegistrationRequest(
    @NotBlank(message = AppMessages.NOME_INVALIDO)  
    String nome,

    @NotBlank(message = AppMessages.CARGO_INVALIDO)
    String cargo,

    @NotBlank(message = AppMessages.SENHA_INVALIDO)
    String senha,

    Integer hierarquia 
) {
}
