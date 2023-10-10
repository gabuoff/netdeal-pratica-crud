package com.netdeal.br.interfaceadapter.controller;

import com.netdeal.br.businessrule.message.AppMessages;
import com.netdeal.br.businessrule.usecase.HierarquiaService;
import com.netdeal.br.domain.dto.RegisterHierarquia;
import com.netdeal.br.domain.model.Hierarquia;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

@SpringBootTest
public class HierarquiaControllerTest {

    @InjectMocks
    private HierarquiaController hierarquiaController;

    @Mock
    private HierarquiaService hierarquiaService;

    @Test
    public void testCriarColaborador() {
        // Arrange
        RegisterHierarquia reg = new RegisterHierarquia(null, null);
        // ... (set any necessary fields on reg)
        doNothing().when(hierarquiaService).salvarHierarquia(any());

        // Act
        ResponseEntity<Object> response = hierarquiaController.criarColaborador(reg);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(AppMessages.REGISTER_SUCCESS, response.getBody());
    }

    @Test
    public void testBuscarTodos() {
        // Arrange
        Hierarquia hierarquia = new Hierarquia();
        // ... (set any necessary fields on hierarquia)
        List<Hierarquia> hierarquias = Collections.singletonList(hierarquia);
        when(hierarquiaService.buscarTodos()).thenReturn(hierarquias);

        // Act
        Iterable<Hierarquia> result = hierarquiaController.buscarTodos();

        // Assert
        assertEquals(hierarquias, result);
    }
}