package org.example.gymfit.model;

import javafx.fxml.FXML;

public enum Sexo {
    MUJER("Mujer"),HOMBRE("Hombre"), OTRO("Otro");
    private final String etiqueta;
    Sexo(String etiqueta)
    {
        this.etiqueta=etiqueta;
    }

    @Override
    public String toString() {
        return "Sexo{" +
                "etiqueta='" + etiqueta + '\'' +
                '}';
    }
}
