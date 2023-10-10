package com.netdeal.br.domain.dto;

import com.netdeal.br.businessrule.message.AppMessages;

import jakarta.validation.constraints.NotBlank;

public record RegistrationRequest(
    @NotBlank(message = AppMessages.NOME_INVALIDO)  
    String nome,

    @NotBlank(message = "Cargo não pode ser vazio")
    String cargo,

    @NotBlank(message = "Senha não pode ser vazio")
    String senha,

    Integer hierarquia 
) {
}
