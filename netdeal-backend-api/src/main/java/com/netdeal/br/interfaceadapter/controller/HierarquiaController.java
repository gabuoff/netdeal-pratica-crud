package com.netdeal.br.interfaceadapter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.netdeal.br.businessrule.message.AppMessages;
import com.netdeal.br.businessrule.usecase.HierarquiaService;
import com.netdeal.br.domain.dto.RegisterHierarquia;
import com.netdeal.br.domain.model.Hierarquia;

@RestController
@RequestMapping("api/hierarquia")
public class HierarquiaController {

    @Autowired
    HierarquiaService hierarquiaService;

    @PostMapping("")
    public ResponseEntity<Object> criarColaborador(@RequestBody RegisterHierarquia reg) {
        hierarquiaService.salvarHierarquia(reg);
        return new ResponseEntity<>(AppMessages.REGISTER_SUCCESS, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Hierarquia> buscarTodos() {
        return hierarquiaService.buscarTodos();
    }
}