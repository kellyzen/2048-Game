package com.example.demo.components.dialogComponent;

public class QuitDialog extends ConfirmationDialog {

    public QuitDialog() {
        String title = "Quit DialogComponent";
        String header = "Quit from this game";
        String context = "Are you sure?";
        ConfirmationDialog continueButton = new ConfirmationDialog();
        continueButton.createButton(title, header, context);
    }
}
