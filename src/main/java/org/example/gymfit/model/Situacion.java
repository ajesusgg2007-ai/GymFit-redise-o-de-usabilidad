package org.example.gymfit.model;

public enum Situacion {
    AL_CORRIENTE("Al corriente"),
    PENDIENTE("Pendiente de pago");
    private final String etiqueta;
    Situacion(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    @Override public String toString() {
        return etiqueta;
    }
}
