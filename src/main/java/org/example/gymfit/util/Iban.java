package org.example.gymfit.util;

public class Iban {
    public static boolean esValido(String iban) {
        if (iban == null || iban.isBlank()) return true; // Opcional
        String limpio = iban.replaceAll("\\s+", "").toUpperCase();
        return limpio.matches("^ES\\d{22}$");
    }
}

