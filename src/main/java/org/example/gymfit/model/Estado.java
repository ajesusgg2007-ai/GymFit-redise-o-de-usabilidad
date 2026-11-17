package org.example.gymfit.model;

public enum Estado {
    OK("OK"),
    VENCIDO("Vencido"),
    BAJA("Baja");

    private final String estado;

    Estado(String estado) {
        this.estado=estado;
    }

    public String getEstado() {
        return estado;
    }
}
