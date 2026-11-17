package org.example.gymfit.model;

public enum Cuota {

    BASICA("Basica",20),
    PLUS("Plus",40),
    JOVEN("Joven",15);

    private String tipo;
    private int precioMes;

    Cuota(String tipo,int precioMes) {
        this.tipo = tipo;
        this.precioMes=precioMes;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPrecio() {
        return precioMes+"€/Mes";
    }

    @Override
    public String toString() {
        return "Cuota{" +
                "tipo='" + tipo + '\'' +
                ", precioMes=" + precioMes +
                '}';
    }
}
