package com.netdeal.br.businessrule.usecase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netdeal.br.businessrule.exception.ValidationException;
import com.netdeal.br.businessrule.mapper.HierarquiaMapper;
import com.netdeal.br.businessrule.validator.Validator;
import com.netdeal.br.domain.dto.RegisterHierarquia;
import com.netdeal.br.domain.model.Hierarquia;
import com.netdeal.br.interfaceadapter.repository.HierarquiaRepository;

@Service
public class HierarquiaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HierarquiaService.class);

    @Autowired
    HierarquiaRepository repository;

    @Autowired
    Validator validator;

    @Transactional
    public void salvarHierarquia(RegisterHierarquia reg) {
        try {
            validator.validateHierarquia(reg.cargo());
            Hierarquia hierarquia = HierarquiaMapper.mapper(reg);
            repository.save(hierarquia);

        } catch (ValidationException ve) {
            LOGGER.error("Erro de validação: ", ve);
            throw ve;
        } catch (Exception e) {
            LOGGER.error("Erro ao salvar o cargo e hierarquia: ", e);
            throw new RuntimeException(e);
        }
    }

    public Iterable<Hierarquia> buscarTodos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            LOGGER.error("Erro ao buscar hierarquias: ", e);
            throw new RuntimeException(e);
        }
    }
}