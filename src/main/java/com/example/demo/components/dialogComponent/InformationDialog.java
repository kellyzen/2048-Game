package com.example.demo.components.dialogComponent;

import javafx.scene.control.Alert;

public class InformationDialog implements DialogComponent {
    @Override
    public void createButton(String title, String header, String context){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }
}
