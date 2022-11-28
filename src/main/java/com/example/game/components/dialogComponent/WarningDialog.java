package com.example.game.components.dialogComponent;

import javafx.scene.control.Alert;

public class WarningDialog implements DialogComponent {
    @Override
    public void createDialog(String title, String header, String context){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
}
