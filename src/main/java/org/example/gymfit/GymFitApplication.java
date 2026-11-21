package org.example.gymfit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;

public class GymFitApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlUrl = getClass().getResource("/main-view.fxml");
        if (fxmlUrl == null) {
            fxmlUrl = getClass().getResource("view/main-view.fxml");
        }
        if (fxmlUrl == null) {
            throw new RuntimeException("No se encuentra main-view.fxml. Revisa que target/classes/org/example/gymfit/view/main-view.fxml exista.");
        }

        FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
        stage.setTitle("GymFit Manager - Gestión de Socios");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}