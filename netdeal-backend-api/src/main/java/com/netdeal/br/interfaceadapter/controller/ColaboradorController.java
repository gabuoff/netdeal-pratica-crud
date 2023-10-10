package com.netdeal.br.interfaceadapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.netdeal.br.businessrule.mapper.ColaboradorMapper;
import com.netdeal.br.businessrule.message.AppMessages;
import com.netdeal.br.businessrule.usecase.ColaboradorService;
import com.netdeal.br.domain.dto.RegistrationRequest;
import com.netdeal.br.domain.model.Colaborador;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorController {

    @Autowired
    ColaboradorService colaboradorService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> criarColaborador(@RequestBody RegistrationRequest reg) {
        Colaborador colaborador = ColaboradorMapper.mapper(reg);
        colaboradorService.salvarColaborador(colaborador);
        return new ResponseEntity<>(AppMessages.REGISTER_SUCCESS, HttpStatus.CREATED);
    }

    @GetMapping("/buscar-todos")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Colaborador> buscarTodos() {
        return colaboradorService.buscarTodos();
    }
}