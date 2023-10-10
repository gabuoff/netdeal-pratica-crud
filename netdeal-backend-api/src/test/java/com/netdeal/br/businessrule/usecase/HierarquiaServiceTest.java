package com.netdeal.br.businessrule.usecase;

import com.netdeal.br.domain.entities.RegisterHierarquia;
import com.netdeal.br.domain.model.Hierarquia;
import com.netdeal.br.interfaceadapter.repository.HierarquiaRepository;
import com.netdeal.br.businessrule.validator.Validator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class HierarquiaServiceTest {

    @InjectMocks
    private HierarquiaService hierarquiaService;

    @Mock
    private HierarquiaRepository repository;

    @Mock
    private Validator validator;

    @Test
    public void testSalvarHierarquia() {
        RegisterHierarquia reg = new RegisterHierarquia("Gerente", String.valueOf(1));
        Hierarquia hierarquia = Hierarquia.builder().cargo("Gerente").hierarquia("1").build();

        doNothing().when(validator).validateHierarquia(anyString(), anyInt());
        when(repository.save(any(Hierarquia.class))).thenReturn(hierarquia);

        hierarquiaService.salvarHierarquia(reg);

        verify(validator, times(1)).validateHierarquia(anyString(), anyInt());
        verify(repository, times(1)).save(any(Hierarquia.class));
    }

    @Test
    public void testBuscarTodos() {
        Hierarquia hierarquia = new Hierarquia();
        when(repository.findAll()).thenReturn(List.of(hierarquia));

        Iterable<Hierarquia> result = hierarquiaService.buscarTodos();

        assertNotNull(result);
        verify(repository, times(1)).findAll();
    }

}
