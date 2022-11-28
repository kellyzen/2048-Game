package com.example.game.components.dialogComponent;

public class CongratulationDialog extends ConfirmationDialog {

    public CongratulationDialog() {
        String title = "Information Dialog";
        String header = "Congratulations, you've reached 2048!";
        String context = "Click 'OK' if you wish to exit game\nClick 'Cancel' if you wish to continue game";
        ConfirmationDialog continueButton = new ConfirmationDialog();
        continueButton.createDialog(title, header, context);
    }
}
