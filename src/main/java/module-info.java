module org.example.gymfit {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gymfit to javafx.fxml;
    exports org.example.gymfit;
    exports org.example.gymfit.controller;
    opens org.example.gymfit.controller to javafx.fxml;
    exports com.example.demo;
    opens com.example.demo to javafx.fxml;
}