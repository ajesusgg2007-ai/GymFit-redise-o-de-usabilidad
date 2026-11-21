// DatosEjemplo.java
package org.example.gymfit.model;

import java.time.LocalDate;
import java.util.List;

public class DatosEjemplo {
    public static List<Socio> cargarIniciales() {
        return List.of(
                new Socio("Ana", "López García", LocalDate.of(1999, 3, 12), Sexo.MUJER, "Sevilla", Cuota.PREMIUM, "Yoga", "ES9121000418450200051332"),
                new Socio("Luis", "Pérez Martín", LocalDate.of(2001, 7, 21), Sexo.HOMBRE, "Sevilla", Cuota.BASICA, "Musculación libre", "ES7921000813610123456789"),
                new Socio("Marta", "Díaz Ruiz", LocalDate.of(1988, 11, 30), Sexo.MUJER, "Huelva", Cuota.SENIOR, "Pilates", "ES6000491500051234567892"),
                new Socio("Jose", "Sánchez Mora", LocalDate.of(2005, 2, 2), Sexo.HOMBRE, "Málaga", Cuota.JOVEN, "CrossFit", "ES1000492352082414205416")
        );
    }
}

