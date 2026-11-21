package org.example.gymfit.model;

public enum Estado {
        OK("Activo"),
        CONGELADO("Congelado"),
        BAJA("Baja");

    private final String estado;

    Estado(String estado) {
        this.estado=estado;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "estado='" + estado + '\'' +
                '}';
    }
}
