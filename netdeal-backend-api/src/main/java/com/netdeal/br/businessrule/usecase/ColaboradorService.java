package com.netdeal.br.businessrule.usecase;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import com.netdeal.br.businessrule.exception.ValidationException;
import com.netdeal.br.businessrule.validator.Validator;
import com.netdeal.br.domain.model.Colaborador;
import com.netdeal.br.interfaceadapter.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ColaboradorService.class);

    @Autowired
    ColaboradorRepository repository;

    @Autowired
    Validator validator;

    @Autowired
    private SenhaService senhaService;

    @Transactional
    public void salvarColaborador(Colaborador colaborador) {
        try {
            validator.validateContador(colaborador.getNome());
            int score = senhaService.evaluatePasswordStrength(colaborador.getSenha());
            colaborador.setForcaDaSenha(score);
            repository.save(colaborador);
        } catch (ValidationException ve) {
            LOGGER.error("Erro de validação: ", ve);
            throw ve;
        } catch (Exception e) {
            LOGGER.error("Erro ao salvar o colaborador: ", e);
            throw new RuntimeException(e);
        }
    }

    public Iterable<Colaborador> buscarTodos() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            LOGGER.error("Erro ao buscar hierarquias: ", e);
            throw new RuntimeException(e);
        }
    }
}