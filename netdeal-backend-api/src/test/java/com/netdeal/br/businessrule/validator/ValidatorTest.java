package com.netdeal.br.businessrule.validator;

import com.netdeal.br.businessrule.exception.ValidationException;
import com.netdeal.br.interfaceadapter.repository.ColaboradorRepository;
import com.netdeal.br.interfaceadapter.repository.HierarquiaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ValidatorTest {

    @InjectMocks
    private Validator validator;

    @Mock
    private ColaboradorRepository colaboradorRepository;

    @Mock
    private HierarquiaRepository hierarquiaRepository;

    @Test
    public void testValidateContador() {
        when(colaboradorRepository.existsByNome("Gabriel")).thenReturn(true);

        ValidationException thrown = assertThrows(
                ValidationException.class,
                () -> validator.validateContador("Gabriel")
        );

        assertEquals("Colaborador já cadastrado com este nome.", thrown.getMessage());
        verify(colaboradorRepository, times(1)).existsByNome("Gabriel");
    }

    @Test
    public void testValidateHierarquia() {
        when(hierarquiaRepository.existsByCargo("Gerente")).thenReturn(true);

        ValidationException thrown = assertThrows(
                ValidationException.class,
                () -> validator.validateHierarquia("Gerente", 5)
        );

        assertEquals("Cargo já cadastrado com este nome.", thrown.getMessage());
        verify(hierarquiaRepository, times(1)).existsByCargo("Gerente");
    }

}
