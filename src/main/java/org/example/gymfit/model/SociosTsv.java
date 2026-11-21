package org.example.gymfit.model;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class SociosTsv {
    private static final Path RUTA = Paths.get("socios_gymfit.tsv");

    public static void guardar(List<Socio> socios) {
        try {
            List<String> lineas = socios.stream()
                    .map(s -> String.join("\t",
                            s.nombreCompleto() != null ? s.nombreCompleto() : "",
                            s.getFechaNacimiento() != null ? s.getFechaNacimiento().toString() : "",
                            s.getSexo() != null ? s.getSexo().name() : "",
                            s.getProvincia() != null ? String.valueOf(s.getProvincia()) : "",
                            s.getCuota() != null ? s.getCuota().name() : "",
                            s.getClases() != null ? String.join(",", s.getClases()) : "",
                            s.getIban() != null ? s.getIban() : ""))
                    .collect(Collectors.toList());
            Files.write(RUTA, lineas);
        } catch (IOException ignored) {}
    }
}