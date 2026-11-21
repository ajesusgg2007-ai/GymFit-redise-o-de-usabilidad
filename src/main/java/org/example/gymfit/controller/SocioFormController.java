package org.example.gymfit.controller;

import org.example.gymfit.model.*;
import org.example.gymfit.util.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.util.List;

import java.util.Optional;
import java.util.function.Consumer;

public class SocioFormController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellidos;
    @FXML private DatePicker dpFechaNac;
    @FXML private ToggleGroup grupoSexo;
    @FXML private RadioButton rbMujer, rbHombre, rbOtro;
    @FXML private ComboBox<String> cbProvincia;
    @FXML private ToggleGroup grupoCuota;
    @FXML private RadioButton rbBasica, rbPlus, rbPremium, rbJoven, rbSenior;
    @FXML private ComboBox<String> cbClases;
    @FXML private TextField txtIban;

    @FXML private VBox boxError;
    @FXML private Label lblTituloError;
    @FXML private Label lblDetalleError;

    private Consumer<Socio> onSocioGuardado;

    public void setOnSocioGuardado(Consumer<Socio> callback) { this.onSocioGuardado = callback; }

    @FXML
    public void initialize() {
        cbProvincia.setItems(FXCollections.observableArrayList(Provincia.getProvincias()));
        cbClases.setItems(FXCollections.observableArrayList(Clases.getClasesDisponibles()));
    }

    @FXML
    public void handleGuardar() {
        if (Textos.esVacio(txtNombre.getText()) || Textos.esVacio(txtApellidos.getText())
                || dpFechaNac.getValue() == null || cbProvincia.getValue() == null) {
            mostrarError("Faltan datos obligatorios",
                    "Rellena Nombre, Apellidos, Fecha de nacimiento y Provincia (*) antes de guardar la ficha.");
            return;
        }
        if (!Iban.esValido(txtIban.getText())) {
            mostrarError("Formato de IBAN incorrecto",
                    "El IBAN debe comenzar por ES seguido de 22 dígitos (Ej. ES91 2100 0418 45 0200051332) o dejarse en blanco.");
            return;
        }

        ocultarError();

        Sexo sexo = rbHombre.isSelected() ? Sexo.HOMBRE : (rbOtro.isSelected() ? Sexo.OTRO : Sexo.MUJER);
        Cuota cuota = Cuota.BASICA;
        if (rbPlus.isSelected()) cuota = Cuota.PLUS;
        else if (rbPremium.isSelected()) cuota = Cuota.PREMIUM;
        else if (rbJoven.isSelected()) cuota = Cuota.JOVEN;
        else if (rbSenior.isSelected()) cuota = Cuota.SENIOR;

        String clase = cbClases.getValue() != null ? cbClases.getValue() : "Sin asignar";

        Socio nuevo = new Socio(
                txtNombre.getText().trim(),
                txtApellidos.getText().trim(),
                dpFechaNac.getValue(),
                sexo,
                cbProvincia.getValue(),
                cuota,
                clase,
                txtIban.getText().trim()
        );

        SocioRepository.agregar(nuevo);
        if (onSocioGuardado != null) onSocioGuardado.accept(nuevo);
        limpiarDirecto();
    }

    @FXML
    public void handleLimpiar() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar limpieza");
        alert.setHeaderText("¿Deseas borrar todos los datos introducidos en el formulario?");
        alert.setContentText("Esta acción no se puede deshacer.");
        Optional<ButtonType> res = alert.showAndWait();
        if (res.isPresent() && res.get() == ButtonType.OK) {
            limpiarDirecto();
        }
    }

    public void limpiarDirecto() {
        txtNombre.clear();
        txtApellidos.clear();
        dpFechaNac.setValue(null);
        rbMujer.setSelected(true);
        cbProvincia.getSelectionModel().clearSelection();
        rbBasica.setSelected(true);
        cbClases.getSelectionModel().clearSelection();
        txtIban.clear();
        ocultarError();
        txtNombre.requestFocus();
    }

    private void mostrarError(String titulo, String detalle) {
        lblTituloError.setText(titulo);
        lblDetalleError.setText(detalle);
        boxError.setVisible(true);
        boxError.setManaged(true);
    }

    private void ocultarError() {
        boxError.setVisible(false);
        boxError.setManaged(false);
    }
}
