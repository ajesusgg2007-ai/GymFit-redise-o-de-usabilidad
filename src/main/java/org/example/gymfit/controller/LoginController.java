package org.example.gymfit.controller;

import org.example.gymfit.model.Cuota;
import org.example.gymfit.model.Estado;
import org.example.gymfit.model.Usuario;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class LoginController {
    private static final String CLASE_ERROR = "con-error";

    @FXML private TextField usuarioField;
    @FXML private PasswordField contrasenaField;
    @FXML private Label errorLabel;
    @FXML private Button entrarButton;

    private Consumer<Usuario> alEntrar;
    private Runnable alSalir;

    @FXML
    private void initialize() {
        // "Entrar" solo se activa con usuario y contraseña escritos.
        entrarButton.disableProperty().bind(
                usuarioField.textProperty().isEmpty().or(contrasenaField.textProperty().isEmpty()));

        // En cuanto se corrige algo, el error de antes deja de ser cierto.
        usuarioField.textProperty().addListener((o, antes, ahora) -> ocultarError());
        contrasenaField.textProperty().addListener((o, antes, ahora) -> ocultarError());
    }

    public void configurar(Consumer<Usuario> alEntrar, Runnable alSalir) {
        this.alEntrar = alEntrar;
        this.alSalir = alSalir;
    }

    @FXML
    private void entrar() {
        if (entrarButton.isDisable()) {
            return;
        }
        Usuario usuario=new Usuario();

        if (usuario.isPresent()) {
            alEntrar.accept(usuario.get());
            return;
        }
        // Se vacía antes de avisar: vaciar el campo también oculta el error.
        contrasenaField.clear();
        mostrarError("Usuario o contraseña incorrectos.");
        marcarCampos(true);
        contrasenaField.requestFocus();
    }

    @FXML
    private void limpiar() {
        usuarioField.clear();
        contrasenaField.clear();
        ocultarError();
        usuarioField.requestFocus();
    }

    @FXML
    private void enfocarUsuario() {
        usuarioField.requestFocus();
    }

    @FXML
    private void acercaDe() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION,
                "GymFit · gestión de socios del gimnasio.\nEntra con tu usuario para ver y editar las fichas.",
                ButtonType.CLOSE);
        alerta.setHeaderText("Acerca de GymFit");
        alerta.showAndWait();
    }

    @FXML
    private void salir() {
        alSalir.run();
    }

    private void mostrarError(String mensaje) {
        errorLabel.setText(mensaje);
        errorLabel.setVisible(true);
        errorLabel.setManaged(true);
    }

    private void ocultarError() {
        errorLabel.setVisible(false);
        errorLabel.setManaged(false);
        marcarCampos(false);
    }

    private void marcarCampos(boolean conError) {
        for (TextField campo : List.of(usuarioField, contrasenaField)) {
            campo.getStyleClass().remove(CLASE_ERROR);
            if (conError) {
                campo.getStyleClass().add(CLASE_ERROR);
            }
        }
    }
}
