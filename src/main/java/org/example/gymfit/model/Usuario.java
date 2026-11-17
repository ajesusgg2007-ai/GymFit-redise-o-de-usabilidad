package org.example.gymfit.model;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Ficha de un socio. Es inmutable: cada cambio crea una copia, lo que hace trivial deshacer. */
public class Usuario {
   private String id;
   private String nombre;
   private String apellido1;
   private String apellido2;
   private LocalDate fechaNacimiento;
   private String sexo;
   private Cuota cuota;
   private Estado estado;
   private String iban;
   private LocalDate vencimiento;

    private static final int DIAS_AVISO_VENCIMIENTO = 7;


}