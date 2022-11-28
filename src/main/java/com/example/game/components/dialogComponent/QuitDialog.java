package com.example.game.components.dialogComponent;

public class QuitDialog extends ConfirmationDialog {

    public QuitDialog() {
        String title = "Quit Dialog";
        String header = "Quit from this game";
        String context = "Are you sure?";
        ConfirmationDialog continueButton = new ConfirmationDialog();
        continueButton.createDialog(title, header, context);
    }
}
