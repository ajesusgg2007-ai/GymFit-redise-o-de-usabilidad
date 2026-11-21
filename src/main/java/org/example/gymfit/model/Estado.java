package org.example.gymfit.model;

public enum Estado {
        ACTIVO("Activo"),
        CONGELADO("Congelado"),
        BAJA("Baja");

    private final String estado;

    Estado(String estado) {
        this.estado=estado;
    }


}
