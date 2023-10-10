package com.netdeal.br.businessrule.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netdeal.br.businessrule.exception.ValidationException;
import com.netdeal.br.businessrule.message.AppMessages;
import com.netdeal.br.interfaceadapter.repository.ColaboradorRepository;
import com.netdeal.br.interfaceadapter.repository.HierarquiaRepository;

@Component
public class Validator {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    HierarquiaRepository hierarquiaRepository;

    public void validateContador(String nome) {
        if(colaboradorRepository.existsByNome(nome)){
            throw new ValidationException(AppMessages.COLABORADOR_USUARIO_CADASTRADO);
        }
    }

    public void validateHierarquia(String cargo, Integer hierarquia) {
        if(hierarquia == null || hierarquia <= 0 || hierarquia > 10){
            throw new ValidationException(AppMessages.HIERARQUIA_INVALIDO);
        }
        if(hierarquiaRepository.existsByCargo(cargo)){
            throw new ValidationException(AppMessages.COLABORADOR_CARGO_CADASTRADO);
        }
    }


}