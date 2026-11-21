module org.example.gymfit {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.gymfit to javafx.fxml;
    opens org.example.gymfit.controller to javafx.fxml;
    opens org.example.gymfit.model to javafx.base;
    opens org.example.gymfit.view;

    exports org.example.gymfit;
    exports org.example.gymfit.controller;
    exports org.example.gymfit.model;
}