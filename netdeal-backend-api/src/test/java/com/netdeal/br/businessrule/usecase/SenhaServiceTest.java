package com.netdeal.br.businessrule.usecase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SenhaServiceTest {

    @Autowired
    private SenhaService senhaService;

    @Test
    public void testEvaluatePasswordStrength() {
        // Testar senha muito fraca
        assertEquals(0, senhaService.evaluatePasswordStrength(""));

        // Testar senha fraca
        assertEquals(16, senhaService.evaluatePasswordStrength("abcd"));

        // Testar senha média
        assertEquals(72, senhaService.evaluatePasswordStrength("abcd1234"));

        // Testar senha forte
        assertEquals(95, senhaService.evaluatePasswordStrength("Abcd1234!"));

        // Testar senha muito forte
        assertEquals(100, senhaService.evaluatePasswordStrength("Abc!2@3#4$"));
    }

}
