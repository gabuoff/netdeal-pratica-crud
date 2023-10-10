package com.netdeal.br.domain.entities;

import com.netdeal.br.businessrule.message.AppMessages;
import jakarta.validation.constraints.NotBlank;

public record RegistrationRequest(
    @NotBlank(message = AppMessages.NOME_INVALIDO)  
    String nome,
    
    @NotBlank(message = AppMessages.SENHA_INVALIDO)
    String senha,

    @NotBlank(message = AppMessages.CARGO_INVALIDO)
    RegisterHierarquia cargo
) {
}
