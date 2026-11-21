package org.example.gymfit.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SocioRepository {
    private static final ObservableList<Socio> socios = FXCollections.observableArrayList(DatosEjemplo.cargarIniciales());

    public static ObservableList<Socio> getSocios() { return socios; }

    public static void agregar(Socio socio) {
        socios.add(socio);
        SociosTsv.guardar(socios);
    }

    public static void eliminar(Socio socio) {
        socios.remove(socio);
        SociosTsv.guardar(socios);
    }
}
