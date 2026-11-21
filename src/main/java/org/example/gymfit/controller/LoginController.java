package org.example.gymfit.controller;

import com.example.demo.model.*;
import com.example.demo.util.Fechas;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Optional;

public class MainController {

    @FXML private TableView<Socio> tablaSocios;
    @FXML private TableColumn<Socio, String> colNombre;
    @FXML private TableColumn<Socio, String> colFechaNac;
    @FXML private TableColumn<Socio, String> colProvincia;
    @FXML private TableColumn<Socio, String> colCuota;
    @FXML private TableColumn<Socio, String> colClase;
    @FXML private Label lblEstado;

    @FXML private SocioFormController socioFormController; // Inyectado desde fx:include

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getNombreCompleto()));
        colFechaNac.setCellValueFactory(d -> new SimpleStringProperty(Fechas.formatear(d.getValue().getFechaNacimiento())));
        colProvincia.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getProvincia()));
        colCuota.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getCuota().toString()));
        colClase.setCellValueFactory(d -> new SimpleStringProperty(d.getValue().getClase()));

        tablaSocios.setItems(SocioRepository.getSocios());
        if (socioFormController != null) {
            socioFormController.setOnSocioGuardado(s -> lblEstado.setText("Socio '" + s.getNombreCompleto() + "' guardado correctamente."));
        }
    }

    @FXML
    private void handleNuevoSocio() {
        if (socioFormController != null) socioFormController.limpiarDirecto();
    }

    @FXML
    private void handleGuardarSocio() {
        if (socioFormController != null) socioFormController.handleGuardar();
    }

    @FXML
    private void handleLimpiarFormulario() {
        if (socioFormController != null) socioFormController.handleLimpiar();
    }

    @FXML
    private void handleVerDetalle() {
        Socio seleccionado = tablaSocios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) return;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/view/detalle-view.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Ficha de " + seleccionado.getNombreCompleto());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(loader.load()));
            DetalleController controller = loader.getController();
            controller.setSocio(seleccionado);
            stage.showAndWait();
        } catch (IOException e) { e.printStackTrace(); }
    }

    @FXML
    private void handleCongelarSocio() {
        Socio seleccionado = tablaSocios.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            seleccionado.setEstado(Estado.CONGELADO);
            lblEstado.setText("Suscripción de " + seleccionado.getNombreCompleto() + " congelada.");
        }
    }

    @FXML
    private void handleEliminarSocio() {
        Socio seleccionado = tablaSocios.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            Alert aviso = new Alert(Alert.AlertType.WARNING, "Selecciona un socio de la tabla antes de pulsar 'Dar de baja'.");
            aviso.setHeaderText("Ningún socio seleccionado");
            aviso.showAndWait();
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar baja");
        confirm.setHeaderText("¿Dar de baja a " + seleccionado.getNombreCompleto() + "?");
        confirm.setContentText("Esta acción eliminará su ficha del listado activo.");
        Optional<ButtonType> res = confirm.showAndWait();
        if (res.isPresent() && res.get() == ButtonType.OK) {
            SocioRepository.eliminar(seleccionado);
            lblEstado.setText("Baja tramitada correctamente.");
        }
    }

    @FXML
    private void handleAyuda() {
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Ayuda - GymFit Manager");
        info.setHeaderText("Guía rápida de recepción");
        info.setContentText("1. Rellena los campos obligatorios (*).\n2. Pulsa 'Guardar Socio' o usa Ctrl+S.\n3. Haz clic derecho sobre una fila de la tabla para ver opciones rápidas.");
        info.showAndWait();
    }

    @FXML
    private void handleSalir() { System.exit(0); }
}