package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GymFitApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(GymFitApplication.class.getResource("/com/example/demo/view/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 800);
        stage.setTitle("GymFit Manager - Gestión de Socios");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}