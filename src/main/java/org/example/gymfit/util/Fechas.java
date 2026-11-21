package org.example.gymfit.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Fechas {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String formatear(LocalDate fecha) {
        return fecha != null ? fecha.format(FORMATO) : "";
    }
}
