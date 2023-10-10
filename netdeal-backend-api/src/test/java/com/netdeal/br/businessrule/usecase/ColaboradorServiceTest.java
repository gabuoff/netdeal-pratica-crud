package com.netdeal.br.businessrule.usecase;

import com.netdeal.br.businessrule.validator.Validator;
import com.netdeal.br.domain.model.Colaborador;
import com.netdeal.br.interfaceadapter.repository.ColaboradorRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ColaboradorServiceTest {

    @InjectMocks
    private ColaboradorService colaboradorService;

    @Mock
    private ColaboradorRepository repository;

    @Mock
    private Validator validator;

    @Mock
    private SenhaService senhaService;

    @Test
    public void testSalvarColaborador() {
        // Arrange
        Colaborador colaborador = new Colaborador();
        // ... (set any necessary fields on colaborador)
        when(senhaService.evaluatePasswordStrength(anyString())).thenReturn(80);

        // Act
        colaboradorService.salvarColaborador(colaborador);

        // Assert
        verify(validator, times(1)).validateContador(null);
        verify(senhaService, times(1)).evaluatePasswordStrength(null);
        verify(repository, times(1)).save(any());
    }

    @Test
    public void testBuscarTodos() {
        // Arrange
        Colaborador colaborador = new Colaborador();
        // ... (set any necessary fields on colaborador)
        List<Colaborador> colaboradores = Collections.singletonList(colaborador);
        when(repository.findAll()).thenReturn(colaboradores);

        // Act
        Iterable<Colaborador> result = colaboradorService.buscarTodos();

        // Assert
        assertEquals(colaboradores, result);
        verify(repository, times(1)).findAll();
    }

}
