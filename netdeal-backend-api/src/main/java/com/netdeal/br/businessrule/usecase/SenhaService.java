package com.netdeal.br.businessrule.usecase;

import java.util.regex.*;

import org.springframework.stereotype.Service;

@Service
public class SenhaService {
    
    public int evaluatePasswordStrength(String password) {
        int score = 0;
        int len = password.length();

        // Additions
        score += len * 4;
        score += (len - countMatches("[A-Z]", password)) * 2;  // Uppercase Letters
        score += (len - countMatches("[a-z]", password)) * 2;  // Lowercase Letters
        score += countMatches("\\d", password) * 4;            // Numbers
        score += countMatches("\\W", password) * 6;            // Symbols
        score += countMiddleNumbersOrSymbols(password) * 2;    // Middle Numbers or Symbols
        score += checkRequirements(password) * 2;             // Requirements

        // Deductions
        if (password.matches("^[a-zA-Z]+$")) score -= len;      // Letters Only
        if (password.matches("^\\d+$")) score -= len;           // Numbers Only
        score -= countRepeatCharacters(password);               // Repeat Characters
        score -= countConsecutive("[A-Z]", password) * 2;        // Consecutive Uppercase Letters
        score -= countConsecutive("[a-z]", password) * 2;        // Consecutive Lowercase Letters
        score -= countConsecutive("\\d", password) * 2;         // Consecutive Numbers
        score -= countSequential("abcdefghijklmnopqrstuvwxyz", 3, password) * 3;  // Sequential Letters (3+)
        score -= countSequential("0123456789", 3, password) * 3;                // Sequential Numbers (3+)
        score -= countSequential("!@#$%^&*(){}[]:;<>,.?/~_+-=|\\", 3, password) * 3;  // Sequential Symbols (3+)

        // Cap score between 0 and 100
        score = Math.max(0, Math.min(score, 100));

        return score;
    }

    private int countMatches(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private int countMiddleNumbersOrSymbols(String password) {
        if (password.length() < 3) {
            return 0;  // Não há caracteres médios em uma senha de menos de 3 caracteres
        }
        String middle = password.substring(1, password.length() - 1);
        return countMatches("\\d|\\W", middle);
    }

    private int checkRequirements(String password) {
        int requirements = 0;
        if (password.length() >= 8) requirements++;
        if (countMatches("[A-Z]", password) > 0) requirements++;
        if (countMatches("[a-z]", password) > 0) requirements++;
        if (countMatches("\\d", password) > 0) requirements++;
        if (countMatches("\\W", password) > 0) requirements++;
        return requirements;
    }

    private int countRepeatCharacters(String password) {
        // This is a simplified repeat character check. A more complete implementation is needed.
        int repeats = 0;
        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                repeats++;
            }
        }
        return repeats;
    }

    private int countConsecutive(String regex, String text) {
        Matcher matcher = Pattern.compile(regex).matcher(text);
        int count = 0;
        while (matcher.find()) {
            if (matcher.start() > 0 && matcher.start() - 1 == matcher.end()) {
                count++;
            }
        }
        return count;
    }

    private int countSequential(String alphabet, int seqLength, String password) {
        int count = 0;
        for (int i = 0; i < alphabet.length() - seqLength + 1; i++) {
            String seq = alphabet.substring(i, i + seqLength);
            if (password.contains(seq) || password.contains(new StringBuilder(seq).reverse().toString())) {
                count++;
            }
        }
        return count;
    }
}
