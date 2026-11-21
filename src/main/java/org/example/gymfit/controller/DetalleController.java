package org.example.gymfit.controller;

import org.example.gymfit.model.Socio;
import org.example.gymfit.util.Fechas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DetalleController {

    @FXML private Label lblNombreCompleto, lblFechaNac, lblSexo, lblProvincia, lblCuota, lblClase, lblIban, lblEstado;

    public void setSocio(Socio s) {
        lblNombreCompleto.setText(s.nombreCompleto());
        lblFechaNac.setText(Fechas.formatear(s.getFechaNacimiento()));
        lblSexo.setText(s.getSexo().toString());
        lblProvincia.setText(String.valueOf(s.getProvincia()));
        lblCuota.setText(s.getCuota().toString());
        lblClase.setText(String.valueOf(s.getClases()));
        lblIban.setText(s.getIban().isEmpty() ? "No domiciliado" : s.getIban());
        lblEstado.setText(s.getEstado().toString() + " (" + s.getSituacion().toString() + ")");
    }

    @FXML
    private void handleCerrar() {
        ((Stage) lblNombreCompleto.getScene().getWindow()).close();
    }
}