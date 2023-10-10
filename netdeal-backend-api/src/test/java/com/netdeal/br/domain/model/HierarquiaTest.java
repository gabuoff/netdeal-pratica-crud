package com.netdeal.br.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HierarquiaTest {

    @Test
    public void testGetterSetter() {
        Hierarquia hierarquia = new Hierarquia();
        hierarquia.setId("123");
        hierarquia.setCargo("Gerente");
        hierarquia.setHierarquia(1);

        assertEquals("123", hierarquia.getId());
        assertEquals("Gerente", hierarquia.getCargo());
        assertEquals(1, hierarquia.getHierarquia());
    }

    @Test
    public void testAllArgsConstructor() {
        Hierarquia hierarquia = new Hierarquia("123", "Gerente", 1);

        assertEquals("123", hierarquia.getId());
        assertEquals("Gerente", hierarquia.getCargo());
        assertEquals(1, hierarquia.getHierarquia());
    }

    @Test
    public void testEqualsAndHashCode() {
        Hierarquia hierarquia1 = new Hierarquia("123", "Gerente", 1);
        Hierarquia hierarquia2 = new Hierarquia("123", "Gerente", 1);
        Hierarquia hierarquia3 = new Hierarquia("456", "Diretor", 2);

        assertEquals(hierarquia1, hierarquia2);
        assertNotEquals(hierarquia1, hierarquia3);
        assertEquals(hierarquia1.hashCode(), hierarquia2.hashCode());
        assertNotEquals(hierarquia1.hashCode(), hierarquia3.hashCode());
    }

    @Test
    public void testBuilder() {
        Hierarquia hierarquia = Hierarquia.builder()
                .id("123")
                .cargo("Gerente")
                .hierarquia(1)
                .build();

        assertEquals("123", hierarquia.getId());
        assertEquals("Gerente", hierarquia.getCargo());
        assertEquals(1, hierarquia.getHierarquia());
    }

}
