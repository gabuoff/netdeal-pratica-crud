package com.netdeal.br.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColaboradorTest {

    @Test
    public void testGetterSetter() {
        Colaborador colaborador = new Colaborador();
        colaborador.setId("123");
        colaborador.setNome("John Doe");
        colaborador.setCargo("Gerente");
        colaborador.setSenha("password123");
        colaborador.setHierarquia("1");
        colaborador.setForcaDaSenha(80);

        assertEquals("123", colaborador.getId());
        assertEquals("John Doe", colaborador.getNome());
        assertEquals("Gerente", colaborador.getCargo());
        assertEquals("password123", colaborador.getSenha());
        assertEquals(1, colaborador.getHierarquia());
        assertEquals(80, colaborador.getForcaDaSenha());
    }

    @Test
    public void testAllArgsConstructor() {
        Colaborador colaborador = new Colaborador("123", "John Doe", "Gerente", "password123", "1", 80);

        assertEquals("123", colaborador.getId());
        assertEquals("John Doe", colaborador.getNome());
        assertEquals("Gerente", colaborador.getCargo());
        assertEquals("password123", colaborador.getSenha());
        assertEquals(1, colaborador.getHierarquia());
        assertEquals(80, colaborador.getForcaDaSenha());
    }

    @Test
    public void testEqualsAndHashCode() {
        Colaborador colaborador1 = new Colaborador("123", "John Doe", "Gerente", "password123", "1", 80);
        Colaborador colaborador2 = new Colaborador("123", "John Doe", "Gerente", "password123", "1", 80);
        Colaborador colaborador3 = new Colaborador("456", "Jane Doe", "Diretor", "password456", "2", 90);

        assertEquals(colaborador1, colaborador2);
        assertNotEquals(colaborador1, colaborador3);
        assertEquals(colaborador1.hashCode(), colaborador2.hashCode());
        assertNotEquals(colaborador1.hashCode(), colaborador3.hashCode());
    }

    @Test
    public void testBuilder() {
        Colaborador colaborador = Colaborador.builder()
                .id("123")
                .nome("John Doe")
                .cargo("Gerente")
                .senha("password123")
                .hierarquia("1")
                .forcaDaSenha(80)
                .build();

        assertEquals("123", colaborador.getId());
        assertEquals("John Doe", colaborador.getNome());
        assertEquals("Gerente", colaborador.getCargo());
        assertEquals("password123", colaborador.getSenha());
        assertEquals(1, colaborador.getHierarquia());
        assertEquals(80, colaborador.getForcaDaSenha());
    }

}
