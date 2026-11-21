package org.example.gymfit.model;

public enum Cuota {

    BASICA("Basica"),
    PLUS("Plus"),
    JOVEN("Joven"),
    SENIOR("Senior"),
    PREMIUM("Premium");

    private final String tipo;

    Cuota(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "tipo='" + tipo + '\'';

    }
}
