package org.example.gymfit.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Socio {

    Estado Estado;
    String id;
    String nombre;
    String apellido1;
    String apellido2;
    LocalDate fechaNacimiento;
    String sexo;
    String provincia;
    Cuota cuota;
    List<String> clases;
    String iban;
    LocalDate vencimiento;

    private static final int DIAS_AVISO_VENCIMIENTO = 7;

    public Socio(String id, String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, String sexo, String provincia, Cuota cuota, List<String> clases, String iban, LocalDate vencimiento, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.provincia = provincia;
        this.cuota = cuota;
        this.clases = clases;
        this.iban = iban;
        this.vencimiento = vencimiento;
        this.Estado = estado;
    }

    public String nombreCompleto() {
        return Stream.of(nombre, apellido1, apellido2)
                .filter(parte -> parte != null && !parte.isBlank())
                .collect(Collectors.joining(" "));
    }

    public int edad(LocalDate hoy) {
        return Period.between(fechaNacimiento, hoy).getYears();
    }

    public Estado estado(LocalDate hoy) {
        return switch (this.Estado) {
            case BAJA -> Estado.BAJA;
            case OK -> Estado.OK;
            case ALTA -> {
                long dias = ChronoUnit.DAYS.between(hoy, vencimiento);
                if (dias < 0) {
                    yield Estado.VENCIDO;
                }
                yield dias <= DIAS_AVISO_VENCIMIENTO ? Estado.VENCE_PRONTO : Estado.AL_DIA;
            }
            default -> this.Estado;
        };
    }

    public Socio setEstado(Estado nuevoEstado){
        return new Socio(id, nombre, apellido1, apellido2, fechaNacimiento, sexo, provincia, cuota,
                clases, iban, vencimiento, nuevoEstado);
    }
}
