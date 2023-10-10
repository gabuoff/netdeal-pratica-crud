package com.netdeal.br.interfaceadapter.controller;

import com.netdeal.br.businessrule.message.AppMessages;
import com.netdeal.br.businessrule.usecase.ColaboradorService;
import com.netdeal.br.domain.dto.RegistrationRequest;
import com.netdeal.br.domain.model.Colaborador;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ColaboradorControllerTest {

    @InjectMocks
    private ColaboradorController colaboradorController;

    @Mock
    private ColaboradorService colaboradorService;

    @Test
    public void testCriarColaborador() {
        // Arrange
        RegistrationRequest reg = new RegistrationRequest(null, null, null, null);
        // ... (set any necessary fields on reg)
        doNothing().when(colaboradorService).salvarColaborador(any());
        // Act
        ResponseEntity<Object> response = colaboradorController.criarColaborador(reg);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(AppMessages.REGISTER_SUCCESS, response.getBody());
    }

    @Test
    public void testBuscarTodos() {
        // Arrange
        Colaborador colaborador = new Colaborador();
        // ... (set any necessary fields on colaborador)
        List<Colaborador> colaboradores = Collections.singletonList(colaborador);
        when(colaboradorService.buscarTodos()).thenReturn(colaboradores);

        // Act
        Iterable<Colaborador> result = colaboradorController.buscarTodos();

        // Assert
        assertEquals(colaboradores, result);
    }

}
