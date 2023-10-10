package com.netdeal.br.businessrule.mapper;

import com.netdeal.br.domain.dto.RegistrationRequest;
import com.netdeal.br.domain.model.Colaborador;

public class ColaboradorMapper {

        public static Colaborador mapper(RegistrationRequest reg) {

                return Colaborador.builder()
                                .nome(reg.nome())
                                .cargo(reg.cargo())
                                .senha(reg.senha())
                                .hierarquia(reg.hierarquia())
                                .build();
        }
}
