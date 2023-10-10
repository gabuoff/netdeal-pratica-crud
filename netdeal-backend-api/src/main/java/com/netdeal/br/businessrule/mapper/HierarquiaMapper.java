package com.netdeal.br.businessrule.mapper;

import com.netdeal.br.domain.dto.RegisterHierarquia;
import com.netdeal.br.domain.model.Hierarquia;

public class HierarquiaMapper {
    
    public static Hierarquia mapper(RegisterHierarquia reg){
            return Hierarquia.builder()
                .cargo(reg.cargo())
                .hierarquia(reg.hierarquia())
                .build();
    }
}
