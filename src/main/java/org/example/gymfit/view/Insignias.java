package org.example.gymfit.view;

import org.example.gymfit.model.Cuota;

import javafx.scene.control.Label;

public class Insignias {
    public static Label crearBadgeCuota(Cuota cuota) {
        Label badge = new Label(cuota.toString());
        badge.getStyleClass().add("badge-cuota");
        if (cuota == Cuota.PREMIUM) badge.getStyleClass().add("badge-premium");
        return badge;
    }
}
